package com.example.protobuf.dto;

public class AddressDTO {

    private String street;
    private String city;
    private int zip;

    public AddressDTO() {
    }

    public AddressDTO(String street, String city, int zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
}
