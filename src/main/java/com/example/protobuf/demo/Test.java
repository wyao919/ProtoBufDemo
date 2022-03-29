package com.example.protobuf.demo;

import com.example.protobuf.dto.AddressDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.models.Address;
import com.proto.models.Addresses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        AddressDTO address1 = new AddressDTO("California Blvd", "Pasadena", 91745);
        AddressDTO address2 = new AddressDTO("Westminster Blvd", "Los Angeles", 90020);
        AddressDTO address3 = new AddressDTO("Sierra Trail Ct", "Hacienda Heights", 91745);
        List<AddressDTO> listOfAddresses = new ArrayList<>();
        listOfAddresses.add(address1);
        listOfAddresses.add(address2);
        listOfAddresses.add(address3);


        Addresses.Builder addressesProto = Addresses.newBuilder();
        List<Address> addressListProto = new ArrayList<>();

//        changeIt(listOfAddresses);

        Optional.ofNullable(listOfAddresses)
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(Optional::ofNullable).collect(Collectors.toList())
                .forEach(addressDTO -> {

                    try {
                        Address.Builder address = Address.newBuilder();
                        String s = convertObjectToJson(addressDTO.get());

//                        address.setCity(addressDTO.get().getCity())
//                                .setZip(addressDTO.get().getZip())
//                                .setStreet(addressDTO.get().getStreet()).build();

                        addressListProto.add(address.build());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        addressListProto.forEach(System.out::println);

        Addresses addressesPROTO = addressesProto.addAllAddress(addressListProto).build();
        System.out.println("=========================================");
        System.out.println(addressesPROTO);




//    private static void changeIt(List<AddressDTO> addressDTOS){
//
//        addressDTOS.add(new AddressDTO("WINN", "WINN", 911));
//
//    }
//
//    private static Map changeIt(Map<Integer,String> map){
//        String two = map.put(2, "Two");
//        System.out.println("Printing ");
//        System.out.println(two);
//
//        System.out.println(map.get(1));
//        return null;
//

    }


    private static String convertObjectToJson (Object object) throws JsonProcessingException {

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);

        }
    }

