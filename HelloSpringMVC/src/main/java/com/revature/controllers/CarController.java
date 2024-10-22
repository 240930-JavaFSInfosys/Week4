package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    //No more Javalin! Which means no more endpoint handlers. It's all done in the Controller

    //Let's make a method that returns a list of cars from a fake database
    @GetMapping //This annotation takes in any HTTP GET Requests ending in /cars
    public ResponseEntity<String> getAllCars(){
        return ResponseEntity.status(200).body("Jeep, Acura, Car, Another car");
    }

}
