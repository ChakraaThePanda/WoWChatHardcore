"""
v4: adds StackMapTable attribute to Code attr of updateGuildiesOnline.

The patched method:
  0: getstatic rotationActive   <- implicit frame: locals=[this], stack=[]
  3: ifne 20                    <- branch to offset 20
  6: getstatic Global$.MODULE$
  ...
  17: invokevirtual changeGuildStatus
  20: return                    <- branch target needs a stack map frame

StackMapTable needed:
  1 entry at offset 20.
  From implicit frame at 0, delta = 20.
  Stack is empty, locals unchanged (just 'this').
  -> same_frame: frame_type = 20 (covers delta 0-63, stack empty, locals same as previous)
  
StackMapTable binary:
  u2 attr_name_index
  u4 attr_length = 4  (u2 number_of_entries + u1 frame_type)
  u2 number_of_entries = 1
  u1 frame_type = 20  (same_frame with offset_delta=20)
"""
import struct, sys, subprocess

def ru2(d, o): return struct.unpack_from('>H', d, o)[0]
def ru4(d, o): return struct.unpack_from('>I', d, o)[0]

with open('wowchat/game/GamePacketHandler.class', 'rb') as f:
    data = bytearray(f.read())

# --- Parse constant pool ---
pool_count = ru2(data, 8)
offset = 10
pool_index = {}
i = 1
while i < pool_count:
    tag = data[offset]
    if tag == 1:
        length = ru2(data, offset+1)
        pool_index[i] = (tag, offset+3, length)
        offset += 3 + length
    elif tag in (7,8,16,19,20): pool_index[i] = (tag, offset+1, 2); offset += 3
    elif tag in (9,10,11,12):   pool_index[i] = (tag, offset+1, 4); offset += 5
    elif tag in (3,4):           pool_index[i] = (tag, offset+1, 4); offset += 5
    elif tag in (5,6):
        pool_index[i] = (tag, offset+1, 8); offset += 9
        i += 1; pool_index[i] = None
    elif tag == 15: pool_index[i] = (tag, offset+1, 3); offset += 4
    elif tag in (17,18): pool_index[i] = (tag, offset+1, 4); offset += 5
    else: print(f"Unknown tag {tag} at i={i}"); sys.exit(1)
    i += 1
pool_end = offset

def find_utf8(s):
    b = s.encode('utf-8')
    for slot, v in pool_index.items():
        if v and v[0] == 1:
            tag, doff, dlen = v
            if bytes(data[doff:doff+dlen]) == b: return slot
    return -1

def find_class_entry(utf8_idx):
    for slot, v in pool_index.items():
        if v and v[0] == 7:
            if ru2(data, v[1]) == utf8_idx: return slot
    return -1

def find_nat(name_idx, desc_idx):
    for slot, v in pool_index.items():
        if v and v[0] == 12:
            if ru2(data, v[1]) == name_idx and ru2(data, v[1]+2) == desc_idx: return slot
    return -1

def find_fieldref(class_idx, nat_idx):
    for slot, v in pool_index.items():
        if v and v[0] == 9:
            if ru2(data, v[1]) == class_idx and ru2(data, v[1]+2) == nat_idx: return slot
    return -1

# Build new CP entries
new_cp_bytes = bytearray()
next_slot = pool_count

def add_utf8(s):
    global next_slot
    existing = find_utf8(s)
    if existing >= 0: return existing
    b = s.encode('utf-8')
    new_cp_bytes.extend([1] + list(struct.pack('>H', len(b))) + list(b))
    idx = next_slot; next_slot += 1
    return idx

def add_class(utf8_idx):
    global next_slot
    existing = find_class_entry(utf8_idx)
    if existing >= 0: return existing
    new_cp_bytes.extend([7] + list(struct.pack('>H', utf8_idx)))
    idx = next_slot; next_slot += 1
    return idx

def add_nat(name_idx, desc_idx):
    global next_slot
    existing = find_nat(name_idx, desc_idx)
    if existing >= 0: return existing
    new_cp_bytes.extend([12] + list(struct.pack('>HH', name_idx, desc_idx)))
    idx = next_slot; next_slot += 1
    return idx

def add_fieldref(class_idx, nat_idx):
    global next_slot
    existing = find_fieldref(class_idx, nat_idx)
    if existing >= 0: return existing
    new_cp_bytes.extend([9] + list(struct.pack('>HH', class_idx, nat_idx)))
    idx = next_slot; next_slot += 1
    return idx

z_idx     = find_utf8("Z")
pub_utf8  = add_utf8("wowchat/discord/GuildOnlineListPublisher")
pub_class = add_class(pub_utf8)
ra_utf8   = add_utf8("rotationActive")
ra_nat    = add_nat(ra_utf8, z_idx)
ra_field  = add_fieldref(pub_class, ra_nat)

# Also add StackMapTable utf8 if not present
smt_utf8  = add_utf8("StackMapTable")

print(f"ra_field=#{ra_field}, StackMapTable=#{smt_utf8}, new pool count={next_slot}")

# Rebuild class with new CP
new_data = bytearray()
new_data += data[:8]
new_data += struct.pack('>H', next_slot)
new_data += data[10:pool_end]
new_data += new_cp_bytes
new_data += data[pool_end:]

# Re-parse helpers on new_data
def skip_pool(d):
    count = ru2(d, 8); offset = 10; i = 1
    while i < count:
        tag = d[offset]
        if tag == 1: offset += 3 + ru2(d, offset+1)
        elif tag in (7,8,16,19,20): offset += 3
        elif tag in (9,10,11,12): offset += 5
        elif tag in (3,4): offset += 5
        elif tag in (5,6): offset += 9; i += 1
        elif tag == 15: offset += 4
        elif tag in (17,18): offset += 5
        else: raise ValueError(f"tag {tag}")
        i += 1
    return offset

def find_utf8_in_data(d, s):
    count = ru2(d, 8); b = s.encode('utf-8'); offset = 10; i = 1
    while i < count:
        tag = d[offset]
        if tag == 1:
            length = ru2(d, offset+1)
            if bytes(d[offset+3:offset+3+length]) == b: return i
            offset += 3 + length
        elif tag in (7,8,16,19,20): offset += 3
        elif tag in (9,10,11,12): offset += 5
        elif tag in (3,4): offset += 5
        elif tag in (5,6): offset += 9; i += 1
        elif tag == 15: offset += 4
        elif tag in (17,18): offset += 5
        i += 1
    return -1

after_pool      = skip_pool(new_data)
update_name_idx = find_utf8_in_data(new_data, "updateGuildiesOnline")
code_attr_idx   = find_utf8_in_data(new_data, "Code")
lvt_attr_idx    = find_utf8_in_data(new_data, "LocalVariableTable")
lnt_attr_idx    = find_utf8_in_data(new_data, "LineNumberTable")
smt_attr_idx    = find_utf8_in_data(new_data, "StackMapTable")
print(f"updateGuildiesOnline=#{update_name_idx} Code=#{code_attr_idx} LVT=#{lvt_attr_idx} LNT=#{lnt_attr_idx} SMT=#{smt_attr_idx}")

# Navigate to methods
offset = after_pool + 6
iface_count = ru2(new_data, offset); offset += 2 + iface_count * 2
field_count = ru2(new_data, offset); offset += 2
for _ in range(field_count):
    offset += 6
    ac = ru2(new_data, offset); offset += 2
    for _ in range(ac):
        offset += 2; al = ru4(new_data, offset); offset += 4 + al

method_count = ru2(new_data, offset); offset += 2
patched = False

for m in range(method_count):
    m_access = ru2(new_data, offset); offset += 2
    m_name   = ru2(new_data, offset); offset += 2
    m_desc   = ru2(new_data, offset); offset += 2
    attr_count = ru2(new_data, offset); offset += 2

    if m_name != update_name_idx:
        for _ in range(attr_count):
            offset += 2; al = ru4(new_data, offset); offset += 4 + al
        continue

    print(f"Found updateGuildiesOnline")
    attrs = []
    for _ in range(attr_count):
        an = ru2(new_data, offset); offset += 2
        al = ru4(new_data, offset); offset += 4
        attrs.append((an, offset, al))
        offset += al

    code_attr = next((a for a in attrs if a[0] == code_attr_idx), None)
    assert code_attr
    an, code_body_start, al = code_attr

    max_stack  = ru2(new_data, code_body_start)
    max_locals = ru2(new_data, code_body_start + 2)
    code_len   = ru4(new_data, code_body_start + 4)
    code_off   = code_body_start + 8
    original_code = bytes(new_data[code_off:code_off + code_len])
    assert original_code[-1] == 0xb1

    # Build new bytecode
    ifne_branch = code_len + 2
    new_code = bytearray()
    new_code += struct.pack('>BH', 0xb2, ra_field)
    new_code += struct.pack('>Bh', 0x9a, ifne_branch)
    new_code += original_code
    new_code_len = len(new_code)
    print(f"  code: {original_code.hex()} -> {new_code.hex()}")

    # Parse sub-attributes
    ex_table_off = code_off + code_len
    ex_count = ru2(new_data, ex_table_off)
    sub_attr_start = ex_table_off + 2 + ex_count * 8
    sub_attr_count = ru2(new_data, sub_attr_start)
    sub_attr_off = sub_attr_start + 2

    new_sub_attrs_list = []
    has_smt = False

    for _ in range(sub_attr_count):
        sa_name = ru2(new_data, sub_attr_off); sub_attr_off += 2
        sa_len  = ru4(new_data, sub_attr_off); sub_attr_off += 4
        sa_body = bytearray(new_data[sub_attr_off:sub_attr_off + sa_len])
        sub_attr_off += sa_len

        if sa_name == lvt_attr_idx:
            lvt_count = ru2(sa_body, 0)
            for ei in range(lvt_count):
                entry_off = 2 + ei * 10
                lv_start  = ru2(sa_body, entry_off)
                lv_length = ru2(sa_body, entry_off + 2)
                if lv_start == 0 and lv_length == code_len:
                    struct.pack_into('>H', sa_body, entry_off + 2, new_code_len)
                    print(f"  LVT entry {ei}: length {code_len} -> {new_code_len}")

        if sa_name == smt_attr_idx:
            has_smt = True

        new_sub_attrs_list.append((sa_name, sa_body))

    # Add StackMapTable if not present
    # We need 1 frame at the branch target (offset 20 = new_code_len - 1)
    # Frame type: same_frame (delta 0-63) -> frame_type = offset_delta
    # offset 20 from start of method, implicit frame at 0
    # offset_delta = 20 (the target offset, since previous frame is at -1 implicitly -> first frame delta = target)
    branch_target = new_code_len - 1  # index of the final 'return' = 20
    # same_frame: frame_type = offset_delta, valid for 0-63
    assert branch_target <= 63, f"Branch target {branch_target} > 63, need different frame type"
    smt_body = struct.pack('>H', 1)  # number_of_entries = 1
    smt_body += struct.pack('>B', branch_target)  # same_frame with offset_delta = branch_target
    print(f"  Adding StackMapTable: 1 entry, same_frame at offset_delta={branch_target}")

    if not has_smt:
        new_sub_attrs_list.append((smt_attr_idx, bytearray(smt_body)))
    else:
        print("  (replacing existing SMT)")
        new_sub_attrs_list = [(n, b) for n, b in new_sub_attrs_list if n != smt_attr_idx]
        new_sub_attrs_list.append((smt_attr_idx, bytearray(smt_body)))

    # Rebuild sub-attrs bytes
    new_sub_attrs = bytearray()
    new_sub_attrs += struct.pack('>H', len(new_sub_attrs_list))
    for sa_name, sa_body in new_sub_attrs_list:
        new_sub_attrs += struct.pack('>HI', sa_name, len(sa_body))
        new_sub_attrs += sa_body

    # Rebuild Code attribute body
    new_code_body = bytearray()
    new_code_body += struct.pack('>HHI', max(max_stack, 1), max_locals, new_code_len)
    new_code_body += new_code
    new_code_body += struct.pack('>H', ex_count)
    new_code_body += new_sub_attrs

    new_code_attr = struct.pack('>HI', code_attr_idx, len(new_code_body))
    new_code_attr += new_code_body

    code_attr_start_in_data = code_body_start - 6
    code_attr_end_in_data   = code_body_start + al

    new_data = (new_data[:code_attr_start_in_data]
                + bytearray(new_code_attr)
                + new_data[code_attr_end_in_data:])
    patched = True
    print("  Patch applied!")
    break

if not patched:
    print("ERROR: not patched"); sys.exit(1)

with open('wowchat/game/GamePacketHandler.class', 'wb') as f:
    f.write(new_data)
print("Wrote patched class")

# Verify
result = subprocess.run(['javap', '-c', '-p', 'wowchat/game/GamePacketHandler.class'],
    capture_output=True, text=True)
idx = result.stdout.find('void updateGuildiesOnline')
if idx >= 0:
    print("\nVerification:")
    print(result.stdout[idx:idx+500])
