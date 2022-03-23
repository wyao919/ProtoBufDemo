package com.example.protobuf.controller;

import com.proto.models.Address;
import com.proto.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/api")
@Component
@Controller
public class DemoController {


    @GET
    @Path("/person")
    @Produces({"application/x-protobuf", "application/json"})
    public Response getPerson(){

        Person build = Person.newBuilder()
                .setAddress(Address.newBuilder().setStreet("Home Address").build())
                .setName("willy")
                .build();

        System.out.println(build);
        return Response.ok(build).build();
    }
}
