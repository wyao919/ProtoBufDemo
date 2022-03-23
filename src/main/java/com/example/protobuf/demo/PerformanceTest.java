package com.example.protobuf.demo;


import com.example.protobuf.json.Jperson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
                Jperson jperson1 = mapper.readValue(valueAsBytes, Jperson.class);
            } catch (Exception e) {
                System.out.println("exception caught");
            }

        };

        //protobuf

        Person wilma = Person.newBuilder().setAge(32).setName("wilma").build();

        System.out.println(wilma);
        System.out.println(wilma.toByteArray());

        Runnable protobuf = () -> {
            byte[] bytes = wilma.toByteArray();
            try {
                Person person = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(protobuf, "PROTO");
        }

    }

    public static void runPerformanceTest(Runnable runnable, String method) {

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " : " + (time2 - time1) + " ms");
    }
}
