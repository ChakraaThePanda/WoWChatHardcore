/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public final class OwnerOnlyChmod$ {
    public static OwnerOnlyChmod$ MODULE$;
    private final EnumSet<PosixFilePermission> posixDir;
    private final EnumSet<PosixFilePermission> posixFile;

    static {
        new OwnerOnlyChmod$();
    }

    private boolean canPosix(Path path) {
        return Files.getFileStore(path).supportsFileAttributeView(PosixFileAttributeView.class);
    }

    private EnumSet<PosixFilePermission> posixDir() {
        return this.posixDir;
    }

    private EnumSet<PosixFilePermission> posixFile() {
        return this.posixFile;
    }

    public void chmod(Path path) {
        if (this.canPosix(path)) {
            Files.setPosixFilePermissions(path, Files.isDirectory(path, new LinkOption[0]) ? this.posixDir() : this.posixFile());
            return;
        }
        AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class, new LinkOption[0]);
        if (view == null) {
            throw new UnsupportedOperationException(new StringBuilder(35).append("Cannot get file attribute view for ").append(path).toString());
        }
        AclEntry.Builder builder = AclEntry.newBuilder();
        builder.setPrincipal(view.getOwner());
        builder.setPermissions(AclEntryPermission.values());
        builder.setType(AclEntryType.ALLOW);
        List<AclEntry> acls = Collections.singletonList(builder.build());
        view.setAcl(acls);
    }

    public void chmodFileOrCreateEmpty(Path path) {
        Files.newByteChannel(path, EnumSet.of(StandardOpenOption.WRITE, StandardOpenOption.CREATE), new FileAttribute[0]).close();
        this.chmod(path);
    }

    public void chmodFileAndWrite(Path path, byte[] contents) {
        try (SeekableByteChannel sbc = Files.newByteChannel(path, EnumSet.of(StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING), new FileAttribute[0]);){
            sbc.write(ByteBuffer.wrap(contents));
        }
        this.chmod(path);
    }

    private OwnerOnlyChmod$() {
        MODULE$ = this;
        this.posixDir = EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE);
        this.posixFile = EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE);
    }
}

