package com.poc.reactiveapp.controllers;


import com.poc.reactiveapp.Person;
import com.poc.reactiveapp.exceptions.ControllerException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/api/vi/reactive")
public class ReactiveController {


    @ExceptionHandler
    public ControllerException handle(IOException ex) {
        return new ControllerException();

    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Person getPerson(@PathVariable Integer id) {
        System.out.println("in getPerson, " + id);
        return new Person(id);
    }

    @PostMapping("/accounts")
    public void handle(@Valid @RequestBody Mono<Account> account) {
        System.out.println("in handle, " + account);
    }

}
