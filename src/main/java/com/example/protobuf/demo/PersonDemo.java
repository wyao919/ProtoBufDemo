package com.example.protobuf.demo;

import com.google.protobuf.Int32Value;
import com.proto.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {

    public static void main(String[] args) throws IOException {

        Person willy = Person.newBuilder()
                .setName("Willy")
                .setAge(Int32Value.newBuilder().setValue(32).build())
                .build();


        Path path = Paths.get("willy.ser");
//        Files.write(path, willy.toByteArray());

        /*
        You can use the below to deserialize the byte array that was
        created by the protobuf
         */
        byte[] bytes = Files.readAllBytes(path);
        Person person = Person.parseFrom(bytes);

        System.out.println(person);

    }
}
