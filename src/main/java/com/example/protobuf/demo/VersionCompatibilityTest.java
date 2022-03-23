package com.example.protobuf.demo;


import com.proto.models.Television;
import com.proto.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {
        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");


        Television samsung = Television.newBuilder()
                .setYear(2016)
                .setModel("Samsung")
                .setType(Type.OLED)
                .build();

//        Files.write(pathV2, samsung.toByteArray());


/*
        Files.write(pathV1, samsung.toByteArray());
        System.out.println(samsung);
        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println(Television.parseFrom(bytes));
*/

    }
}
