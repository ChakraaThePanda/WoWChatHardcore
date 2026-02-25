/*
 * Decompiled with CFR 0.152.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class JavaFeaturesProto {
    public static final int JAVA_FIELD_NUMBER = 1001;
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private JavaFeaturesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add(java_);
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        JavaFeaturesProto.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 28, 2, "", JavaFeaturesProto.class.getName());
        java_ = GeneratedMessage.newFileScopedGeneratedExtension(JavaFeatures.class, JavaFeatures.getDefaultInstance());
        String[] descriptorData = new String[]{"\n#google/protobuf/java_features.proto\u0012\u0002pb\u001a google/protobuf/descriptor.proto\"\u0099\u0005\n\fJavaFeatures\u0012\u008e\u0002\n\u0012legacy_closed_enum\u0018\u0001 \u0001(\bB\u00df\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001\u00a2\u0001\t\u0012\u0004true\u0018\u0084\u0007\u00a2\u0001\n\u0012\u0005false\u0018\u00e7\u0007\u00b2\u0001\u00b9\u0001\b\u00e8\u0007\u0010\u00e8\u0007\u001a\u00b0\u0001The legacy closed enum treatment in Java is deprecated and is scheduled to be removed in edition 2025.  Mark enum type on the enum definitions themselves rather than on fields.R\u0010legacyClosedEnum\u0012\u00af\u0002\n\u000futf8_validation\u0018\u0002 \u0001(\u000e2\u001f.pb.JavaFeatures.Utf8ValidationB\u00e4\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001\u00a2\u0001\f\u0012\u0007DEFAULT\u0018\u0084\u0007\u00b2\u0001\u00c8\u0001\b\u00e8\u0007\u0010\u00e9\u0007\u001a\u00bf\u0001The Java-specific utf8 validation feature is deprecated and is scheduled to be removed in edition 2025.  Utf8 validation behavior should use the global cross-language utf8_validation feature.R\u000eutf8Validation\"F\n\u000eUtf8Validation\u0012\u001b\n\u0017UTF8_VALIDATION_UNKNOWN\u0010\u0000\u0012\u000b\n\u0007DEFAULT\u0010\u0001\u0012\n\n\u0006VERIFY\u0010\u0002:B\n\u0004java\u0012\u001b.google.protobuf.FeatureSet\u0018\u00e9\u0007 \u0001(\u000b2\u0010.pb.JavaFeaturesR\u0004javaB(\n\u0013com.google.protobufB\u0011JavaFeaturesProto"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        internal_static_pb_JavaFeatures_descriptor = JavaFeaturesProto.getDescriptor().getMessageTypes().get(0);
        internal_static_pb_JavaFeatures_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pb_JavaFeatures_descriptor, new String[]{"LegacyClosedEnum", "Utf8Validation"});
        java_.internalInit(descriptor.getExtensions().get(0));
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    public static final class JavaFeatures
    extends GeneratedMessage
    implements JavaFeaturesOrBuilder {
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        private boolean legacyClosedEnum_ = false;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private int utf8Validation_ = 0;
        private byte memoizedIsInitialized = (byte)-1;
        private static final JavaFeatures DEFAULT_INSTANCE;
        private static final Parser<JavaFeatures> PARSER;

        private JavaFeatures(GeneratedMessage.Builder<?> builder) {
            super(builder);
        }

        private JavaFeatures() {
            this.utf8Validation_ = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_pb_JavaFeatures_descriptor;
        }

        @Override
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_pb_JavaFeatures_fieldAccessorTable.ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
        }

        @Override
        public boolean hasLegacyClosedEnum() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public boolean getLegacyClosedEnum() {
            return this.legacyClosedEnum_;
        }

        @Override
        public boolean hasUtf8Validation() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override
        public Utf8Validation getUtf8Validation() {
            Utf8Validation result2 = Utf8Validation.forNumber(this.utf8Validation_);
            return result2 == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : result2;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                output.writeBool(1, this.legacyClosedEnum_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeEnum(2, this.utf8Validation_);
            }
            this.getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) != 0) {
                size += CodedOutputStream.computeBoolSize(1, this.legacyClosedEnum_);
            }
            if ((this.bitField0_ & 2) != 0) {
                size += CodedOutputStream.computeEnumSize(2, this.utf8Validation_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof JavaFeatures)) {
                return super.equals(obj);
            }
            JavaFeatures other = (JavaFeatures)obj;
            if (this.hasLegacyClosedEnum() != other.hasLegacyClosedEnum()) {
                return false;
            }
            if (this.hasLegacyClosedEnum() && this.getLegacyClosedEnum() != other.getLegacyClosedEnum()) {
                return false;
            }
            if (this.hasUtf8Validation() != other.hasUtf8Validation()) {
                return false;
            }
            if (this.hasUtf8Validation() && this.utf8Validation_ != other.utf8Validation_) {
                return false;
            }
            return this.getUnknownFields().equals(other.getUnknownFields());
        }

        @Override
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = 41;
            hash = 19 * hash + JavaFeatures.getDescriptor().hashCode();
            if (this.hasLegacyClosedEnum()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + Internal.hashBoolean(this.getLegacyClosedEnum());
            }
            if (this.hasUtf8Validation()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.utf8Validation_;
            }
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static JavaFeatures parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JavaFeatures parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JavaFeatures parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JavaFeatures parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JavaFeatures parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JavaFeatures parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JavaFeatures parseFrom(InputStream input) throws IOException {
            return GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static JavaFeatures parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static JavaFeatures parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static JavaFeatures parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return JavaFeatures.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(JavaFeatures prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static JavaFeatures getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<JavaFeatures> parser() {
            return PARSER;
        }

        public Parser<JavaFeatures> getParserForType() {
            return PARSER;
        }

        @Override
        public JavaFeatures getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 28, 2, "", JavaFeatures.class.getName());
            DEFAULT_INSTANCE = new JavaFeatures();
            PARSER = new AbstractParser<JavaFeatures>(){

                @Override
                public JavaFeatures parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    Builder builder = JavaFeatures.newBuilder();
                    try {
                        builder.mergeFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(builder.buildPartial());
                    }
                    catch (UninitializedMessageException e) {
                        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
                    }
                    catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(builder.buildPartial());
                    }
                    return builder.buildPartial();
                }
            };
        }

        public static final class Builder
        extends GeneratedMessage.Builder<Builder>
        implements JavaFeaturesOrBuilder {
            private int bitField0_;
            private boolean legacyClosedEnum_;
            private int utf8Validation_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_pb_JavaFeatures_descriptor;
            }

            @Override
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_pb_JavaFeatures_fieldAccessorTable.ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
            }

            private Builder() {
            }

            private Builder(AbstractMessage.BuilderParent parent) {
                super(parent);
            }

            @Override
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.legacyClosedEnum_ = false;
                this.utf8Validation_ = 0;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_pb_JavaFeatures_descriptor;
            }

            @Override
            public JavaFeatures getDefaultInstanceForType() {
                return JavaFeatures.getDefaultInstance();
            }

            @Override
            public JavaFeatures build() {
                JavaFeatures result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public JavaFeatures buildPartial() {
                JavaFeatures result2 = new JavaFeatures(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result2);
                }
                this.onBuilt();
                return result2;
            }

            private void buildPartial0(JavaFeatures result2) {
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) != 0) {
                    result2.legacyClosedEnum_ = this.legacyClosedEnum_;
                    to_bitField0_ |= 1;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result2.utf8Validation_ = this.utf8Validation_;
                    to_bitField0_ |= 2;
                }
                result2.bitField0_ |= to_bitField0_;
            }

            @Override
            public Builder mergeFrom(Message other) {
                if (other instanceof JavaFeatures) {
                    return this.mergeFrom((JavaFeatures)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(JavaFeatures other) {
                if (other == JavaFeatures.getDefaultInstance()) {
                    return this;
                }
                if (other.hasLegacyClosedEnum()) {
                    this.setLegacyClosedEnum(other.getLegacyClosedEnum());
                }
                if (other.hasUtf8Validation()) {
                    this.setUtf8Validation(other.getUtf8Validation());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                this.onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
                    boolean done = false;
                    block10: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block10;
                            }
                            case 8: {
                                this.legacyClosedEnum_ = input.readBool();
                                this.bitField0_ |= 1;
                                continue block10;
                            }
                            case 16: {
                                int tmpRaw = input.readEnum();
                                Utf8Validation tmpValue = Utf8Validation.forNumber(tmpRaw);
                                if (tmpValue == null) {
                                    this.mergeUnknownVarintField(2, tmpRaw);
                                    continue block10;
                                }
                                this.utf8Validation_ = tmpRaw;
                                this.bitField0_ |= 2;
                                continue block10;
                            }
                        }
                        if (super.parseUnknownField(input, extensionRegistry, tag)) continue;
                        done = true;
                    }
                }
                catch (InvalidProtocolBufferException e) {
                    throw e.unwrapIOException();
                }
                finally {
                    this.onChanged();
                }
                return this;
            }

            @Override
            public boolean hasLegacyClosedEnum() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override
            public boolean getLegacyClosedEnum() {
                return this.legacyClosedEnum_;
            }

            public Builder setLegacyClosedEnum(boolean value) {
                this.legacyClosedEnum_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearLegacyClosedEnum() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.legacyClosedEnum_ = false;
                this.onChanged();
                return this;
            }

            @Override
            public boolean hasUtf8Validation() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override
            public Utf8Validation getUtf8Validation() {
                Utf8Validation result2 = Utf8Validation.forNumber(this.utf8Validation_);
                return result2 == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : result2;
            }

            public Builder setUtf8Validation(Utf8Validation value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.utf8Validation_ = value.getNumber();
                this.onChanged();
                return this;
            }

            public Builder clearUtf8Validation() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.utf8Validation_ = 0;
                this.onChanged();
                return this;
            }
        }

        public static enum Utf8Validation implements ProtocolMessageEnum
        {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);

            public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
            public static final int DEFAULT_VALUE = 1;
            public static final int VERIFY_VALUE = 2;
            private static final Internal.EnumLiteMap<Utf8Validation> internalValueMap;
            private static final Utf8Validation[] VALUES;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Utf8Validation valueOf(int value) {
                return Utf8Validation.forNumber(value);
            }

            public static Utf8Validation forNumber(int value) {
                switch (value) {
                    case 0: {
                        return UTF8_VALIDATION_UNKNOWN;
                    }
                    case 1: {
                        return DEFAULT;
                    }
                    case 2: {
                        return VERIFY;
                    }
                }
                return null;
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            @Override
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return Utf8Validation.getDescriptor().getValues().get(this.ordinal());
            }

            @Override
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return Utf8Validation.getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return JavaFeatures.getDescriptor().getEnumTypes().get(0);
            }

            public static Utf8Validation valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != Utf8Validation.getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private Utf8Validation(int value) {
                this.value = value;
            }

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 28, 2, "", Utf8Validation.class.getName());
                internalValueMap = new Internal.EnumLiteMap<Utf8Validation>(){

                    @Override
                    public Utf8Validation findValueByNumber(int number) {
                        return Utf8Validation.forNumber(number);
                    }
                };
                VALUES = Utf8Validation.values();
            }
        }
    }

    public static interface JavaFeaturesOrBuilder
    extends MessageOrBuilder {
        public boolean hasLegacyClosedEnum();

        public boolean getLegacyClosedEnum();

        public boolean hasUtf8Validation();

        public JavaFeatures.Utf8Validation getUtf8Validation();
    }
}

