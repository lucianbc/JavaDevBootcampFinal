package org.bootcamp.vehicle;

public final class Car extends Vehicle {
    private Transmission transmission = Transmission.MANUAL;

    public Car() {}

    public Car(int age, long numberOfMiles, boolean isDiesel) {

        this(age, numberOfMiles, isDiesel, Transmission.MANUAL);
    }

    public Car(int age, long numberOfMiles, boolean isDiesel, Transmission transmission) {
        super(age, numberOfMiles, isDiesel);
        this.transmission = transmission;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }


    public enum Transmission {
        MANUAL,
        AUTO;
    }
}
