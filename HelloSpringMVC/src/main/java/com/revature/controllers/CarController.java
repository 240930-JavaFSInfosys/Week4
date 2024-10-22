package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a combination of @Controller and @ResponseBody
//@Controller is a stereotype annotation - makes a class a Bean in the Spring Container
//@ResponseBody sets every HTTP Response to JSON automatically (no need for Jackson like with Javalin)
@RestController
@RequestMapping("/cars") //Now every HTTP request with /cars will be routed to this Controller
public class CarController {

    //No more Javalin! Which means no more endpoint handlers. It's all done in the Controller

    //Let's make a method that returns a list of cars from a fake database
    @GetMapping //This annotation takes in any HTTP GET Requests ending in /cars
    public ResponseEntity<String> getAllCars(){
        //We're returning a ResponseEntity with a status code of 200 (OK) and a response body of our cars
        return ResponseEntity.status(200).body("Jeep, Acura, Car, Another car");
    }

    //Now here's a method that returns a single car with a hypothetical ID passed as a path variable
    @GetMapping("/{id}") //This annotation takes in any HTTP GET Requests ending in /cars/{some ID}
    //@PathVariable lets you extract variables from the URL path
    public ResponseEntity<String> getCarById(@PathVariable int id){

        //TODO: could check for datatype mismatch in the path variable
        //catch MethodArgumentTypeMismatchException and return 400 etc.

        //We can easily error handle using ResponseEntity!

        if(id <= 0){
            return ResponseEntity.status(400).body("ID must be greater than 0");
        }

        //If the user send in a number > 0, send them back their car and a 200
        return ResponseEntity.ok("Returned car number " + id );

        //^using shorthand for ResponseEntity.status(200).body("blah blah")

    }

}
