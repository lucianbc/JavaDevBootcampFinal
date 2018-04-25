package org.bootcamp.vehicle;

public final class Bus extends Vehicle {
    private int numberOfSeats;

    public Bus() {}

    public Bus(int age, long numberOfMiles, boolean isDiesel) {

        this(age, numberOfMiles, isDiesel, 0);
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel, int numberOfSeats) {
        super(age, numberOfMiles, isDiesel);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
