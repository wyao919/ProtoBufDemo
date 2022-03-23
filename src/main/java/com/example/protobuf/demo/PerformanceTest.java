package com.example.protobuf.demo;


import com.example.protobuf.json.Jperson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.models.Person;

public class PerformanceTest {

    public static void main(String[] args) {

        Jperson jperson = new Jperson();
        jperson.setAge(36);
        jperson.setName("willy");

        ObjectMapper mapper = new ObjectMapper();


        //json
        Runnable json = () -> {

            try {
                byte[] valueAsBytes = mapper.writeValueAsBytes(jperson);
                System.out.println(valueAsBytes.length);
                Jperson jperson1 = mapper.readValue(valueAsBytes, Jperson.class);
            } catch (Exception e) {
                System.out.println("exception caught");
            }

        };

        //protobuf

        Person wilma = Person.newBuilder().setAge(Int32Value.newBuilder().setValue(32).build()).setName("wilma").build();

        System.out.println(wilma);
        System.out.println(wilma.toByteArray());

        Runnable protobuf = () -> {
            try {
                byte[] bytes = wilma.toByteArray();
                System.out.println(bytes.length);

                Person person = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 1; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(protobuf, "PROTO");
        }

    }

    public static void runPerformanceTest(Runnable runnable, String method) {

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " : " + (time2 - time1) + " ms");
    }
}
