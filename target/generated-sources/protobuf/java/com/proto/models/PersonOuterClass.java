// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto

package com.proto.models;

public final class PersonOuterClass {
  private PersonOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014person.proto\032\020common/car.proto\032\024common" +
      "/address.proto\032\036google/protobuf/wrappers" +
      ".proto\"n\n\006Person\022\014\n\004name\030\001 \001(\t\022(\n\003age\030\002 " +
      "\001(\0132\033.google.protobuf.Int32Value\022\031\n\007addr" +
      "ess\030\003 \001(\0132\010.Address\022\021\n\003car\030\004 \003(\0132\004.CarB\024" +
      "\n\020com.proto.modelsP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.proto.models.CarOuterClass.getDescriptor(),
          com.proto.models.AddressOuterClass.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
        }, assigner);
    internal_static_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Person_descriptor,
        new java.lang.String[] { "Name", "Age", "Address", "Car", });
    com.proto.models.CarOuterClass.getDescriptor();
    com.proto.models.AddressOuterClass.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
