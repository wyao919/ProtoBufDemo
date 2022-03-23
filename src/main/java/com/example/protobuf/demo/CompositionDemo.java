package com.example.protobuf.demo;

import com.google.protobuf.Int32Value;
import com.proto.models.Address;
import com.proto.models.Car;
import com.proto.models.Person;

import java.util.ArrayList;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setCity("Hacienda Heights")
                .setZip(91745)
                .setStreet("Sierra Trail Ct.")
                .build();

        Car car = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car car2 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(1999)
                .build();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);


        Person willy = Person.newBuilder()
                .setName("willy")
                .setAge(Int32Value.newBuilder().setValue(32).build())
                .setAddress(address)
                .addAllCar(cars)
                .addCar(car)
                .build();

        System.out.println(willy);

    }
}
