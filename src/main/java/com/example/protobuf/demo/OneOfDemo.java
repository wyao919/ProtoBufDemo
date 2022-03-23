package com.example.protobuf.demo;

import com.proto.models.Credentials;
import com.proto.models.EmailCredentials;
import com.proto.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {

        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("Willyyao@outlook.com")
                .setPassword("admin123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(123123123)
                .setCode(456)
                .build();


        //oneOf will only work for one. You can not set email and phone mode at the same time
        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();
        login(credentials);

    }

    private static void login(Credentials credentials){

        switch (credentials.getModeCase()){
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }
        System.out.println(credentials.getEmailMode());
    }
}
