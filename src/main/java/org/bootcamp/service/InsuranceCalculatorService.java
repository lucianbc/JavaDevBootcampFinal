package org.bootcamp.service;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.bootcamp.service.ConversionUtils.getVehicle;

@Component
public final class InsuranceCalculatorService {

    private final VehicleInfoDao dao;

    public InsuranceCalculatorService(VehicleInfoDao dao) {
        this.dao = dao;
    }

    public List<InsuranceCalculationResult> calculateAll() {

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        final List<InsuranceCalculationResult> calculationResults = new LinkedList<>();

        final List<VehicleInfo> vehicleInfos = dao.getAllVehicles();

        if (vehicleInfos.isEmpty()) {

            return Collections.emptyList();
        }

        vehicleInfos.forEach((vehicleInfo) -> {

            final Vehicle vehicle = getVehicle(vehicleInfo);
            final Formula formula = Formula.valueOf(vehicleInfo.getFormulaTypeName());
            final float totalCost = calculator.calculate(vehicle, formula);

            final InsuranceCalculationResult result = new InsuranceCalculationResult(vehicleInfo.getId(),
                                                        vehicleInfo.getVehicleTypeName(), totalCost);

            calculationResults.add(result);
        });

        return calculationResults;
    }

    public InsuranceCalculationResult calculateById(String id) {

        VehicleInfo vehicleInfo = dao.getVehicleInfoById(id);

        if (vehicleInfo != null) {

            final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
            final Vehicle vehicle = getVehicle(vehicleInfo);
            final Formula formula = Formula.valueOf(vehicleInfo.getFormulaTypeName());
            final float totalCost = calculator.calculate(vehicle, formula);

            return new InsuranceCalculationResult(vehicleInfo.getId(),
                                                            vehicleInfo.getVehicleTypeName(), totalCost);
        }

        return null;
    }

    public List<InsuranceCalculationResult> getCostsHigherThan(float cost) {

        final List<InsuranceCalculationResult> calculationResults = this.calculateAll();

        calculationResults.removeIf(result -> result.getCost() <= cost);

        if (calculationResults.isEmpty()) {

            return Collections.emptyList();
        }

        return calculationResults;
    }
}
