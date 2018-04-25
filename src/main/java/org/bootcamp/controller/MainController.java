package org.bootcamp.controller;

import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class MainController {

    private final InsuranceCalculatorService service;

    public MainController(InsuranceCalculatorService calculatorService) {
        this.service = calculatorService;
    }

    private static final String HELLO_MESSAGE = "<h1>Hello From the Web!</h1>";

    @GetMapping("/")
    private String sayHello() {
        return HELLO_MESSAGE;
    }

    @GetMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InsuranceCalculationResult> calculateAll() {
        return service.calculateAll();
    }

    @GetMapping(value = "/calculate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public InsuranceCalculationResult calculateById(@PathVariable("id") String id) {
        return service.calculateById(id);
    }

    @GetMapping(value = "/calculate/higherThan", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InsuranceCalculationResult> getHigherThan(@RequestParam("max") int max) {
        return service.getCostsHigherThan(max);
    }
}
