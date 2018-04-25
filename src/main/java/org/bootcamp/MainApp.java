package org.bootcamp;

import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private static final String OUTPUT_FORMAT = "%s with id %s has total cost %.2f";

    private final InsuranceCalculatorService calculatorService;

    public MainApp(InsuranceCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    private static void printCalculationResult(InsuranceCalculationResult result) {

        if (result != null) {
            final String output = String.format(OUTPUT_FORMAT, result.getVehicleTypeName(), result.getId(), result.getCost());
            System.out.println(output);
        }
    }

    @Override
    public void run(String... args) {
        final List<InsuranceCalculationResult> resultList1 = calculatorService.calculateAll();
        final List<InsuranceCalculationResult> resultList2 = calculatorService.getCostsHigherThan(1000);

        resultList1.forEach(MainApp::printCalculationResult);

        System.out.println();

        resultList2.forEach(MainApp::printCalculationResult);

        System.out.println();

        printCalculationResult(calculatorService.calculateById("3c997def-3cff-11e8-c243-14de190f32bc"));

    }
}
