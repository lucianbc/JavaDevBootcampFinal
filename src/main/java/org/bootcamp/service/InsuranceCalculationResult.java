package org.bootcamp.service;

public final class InsuranceCalculationResult {

    private final String id;
    private final String vehicleTypeName;
    private final float cost;

    InsuranceCalculationResult(String id, String vehicleTypeName, float cost) {

        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public float getCost() {
        return cost;
    }
}
