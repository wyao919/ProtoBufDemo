package com.example.protobuf.demo;

import com.proto.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person person = Person.newBuilder()
                .build();

        System.out.println(person.getCarList()); //will return blank

        //has method is only created when there is A sub message in a message
        //you will not be able to check any other data types if they are blank like this
        System.out.println(person.hasAddress()); // this is to check if it is null or blank


    }
}
