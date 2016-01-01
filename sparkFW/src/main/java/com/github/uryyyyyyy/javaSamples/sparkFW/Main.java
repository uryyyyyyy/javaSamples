package com.github.uryyyyyyy.javaSamples.sparkFW;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Date;

import static spark.Spark.*;
public class Main {

    public static void main(String[] args){
        get("/hello", (request, response) -> "Hello World");

        get("/json", (request, response) -> {
            response.status(200);
            response.type("application/json");
            MyObj obj = new MyObj();
            obj.id = 1;
            obj.name = "Jon";
            obj.time = new Date();
            return dataToJson(obj);
        });
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(data);
        } catch (IOException e){
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }
}
