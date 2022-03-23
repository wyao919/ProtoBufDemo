package com.example.protobuf.demo;

import com.proto.models.BodyStyle;
import com.proto.models.Car;
import com.proto.models.Dealer;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Car car = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .setBodyStyle(BodyStyle.COUP)
                .build();

        Car car2 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(1999)
                .setBodyStyle(BodyStyle.SEDAN)
                .build();


        Map<Integer, Car> mapOfCars = new HashMap<>();
        mapOfCars.put(car.getYear(), car);
        mapOfCars.put(car2.getYear(), car2);

        Dealer dealer = Dealer.newBuilder()
//                .putModel(2005, car)
//                .putModel(2032, car2)
                .putAllModel(mapOfCars)
                .build();


//        System.out.println(dealer.getModelMap());
//        System.out.println(dealer.getModelOrDefault(2019, car));
        System.out.println(dealer.getModelOrThrow(1999).getBodyStyle());



    }
}
