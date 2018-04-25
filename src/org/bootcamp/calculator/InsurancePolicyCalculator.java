package org.bootcamp.calculator;

import org.bootcamp.vehicle.Vehicle;
import org.bootcamp.formula.Formula;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator() {

    }

    public float calculate(Vehicle vehicle, Formula formula) {

        return formula.calculate(vehicle);
    }
}
