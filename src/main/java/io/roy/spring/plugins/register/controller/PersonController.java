package io.roy.spring.plugins.register.controller;

import io.roy.spring.plugins.register.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
}
