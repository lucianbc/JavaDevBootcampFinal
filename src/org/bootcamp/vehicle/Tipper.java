package org.bootcamp.vehicle;

public final class Tipper extends Vehicle {

    private int capacityInTons;

    public Tipper() {
    }

    public Tipper(int age, long numberOfMiles, boolean isDiesel) {

        this(age, numberOfMiles, isDiesel, 0);
    }

    public Tipper(int age, long numberOfMiles, boolean isDiesel, int capacityInTons) {
        super(age, numberOfMiles, isDiesel);
        this.capacityInTons = capacityInTons;
    }

    public int getCapacityInTons() {
        return capacityInTons;
    }

    public void setCapacityInTons(int capacityInTons) {
        this.capacityInTons = capacityInTons;
    }
}
