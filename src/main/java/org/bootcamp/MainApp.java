package org.bootcamp;

import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class MainApp {

    private static final String OUTPUT_FORMAT = "%s with id %s has total cost %.2f";

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();

        if (args.length >= 1) {

            final String path = args[0];
            final InsuranceCalculatorService service = new InsuranceCalculatorService(path);
            final List<InsuranceCalculationResult> resultList1 = service.calculateAll();
            final List<InsuranceCalculationResult> resultList2 = service.getCostsHigherThan(1000);

            resultList1.forEach(MainApp::printCalculationResult);

            System.out.println();

            resultList2.forEach(MainApp::printCalculationResult);

            System.out.println();

            printCalculationResult(service.calculateById("3c997def-3cff-11e8-c243-14de190f32bc"));

        } else {
            System.out.println("No arguments!");
        }

        final long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + " " + TimeUnit.MILLISECONDS.toString());
    }


    private static void printCalculationResult(InsuranceCalculationResult result) {

        if (result != null) {
            final String output = String.format(OUTPUT_FORMAT, result.getVehicleTypeName(), result.getId(), result.getCost());
            System.out.println(output);
        }
    }
}
