// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common/car.proto

package com.proto.models;

public interface CarOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Car)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string make = 1;</code>
   */
  java.lang.String getMake();
  /**
   * <code>string make = 1;</code>
   */
  com.google.protobuf.ByteString
      getMakeBytes();

  /**
   * <code>string model = 2;</code>
   */
  java.lang.String getModel();
  /**
   * <code>string model = 2;</code>
   */
  com.google.protobuf.ByteString
      getModelBytes();

  /**
   * <code>int32 year = 3;</code>
   */
  int getYear();

  /**
   * <code>.BodyStyle body_style = 4;</code>
   */
  int getBodyStyleValue();
  /**
   * <code>.BodyStyle body_style = 4;</code>
   */
  com.proto.models.BodyStyle getBodyStyle();
}
