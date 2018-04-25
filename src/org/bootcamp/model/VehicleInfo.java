package org.bootcamp.model;

public final class VehicleInfo {

    private String id;
    private String vehicleTypeName;
    private String formulaTypeName;
    private int age;
    private long numberOfMiles;
    private boolean isDiesel;

    private VehicleInfo() {}

    private VehicleInfo(String id, String vehicleTypeName, String formulaTypeName, int age, long numberOfMiles, boolean isDiesel) {

        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.formulaTypeName = formulaTypeName;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public static Builder builder() {

        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public String getFormulaTypeName() {
        return formulaTypeName;
    }

    public int getAge() {
        return age;
    }

    public long getNumberOfMiles() {
        return numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public void setDiesel(boolean diesel) {
        isDiesel = diesel;
    }

    public static final class Builder {

        private String id;
        private String vehicleTypeName;
        private String formulaTypeName;
        private int age;
        private long numberOfMiles;
        private boolean isDiesel;

        private Builder() {}

        public Builder withId(String id) {

            this.id = id;
            return this;
        }

        public Builder withVehicleTypeName(String vehicleTypeName) {

            this.vehicleTypeName = vehicleTypeName;
            return this;
        }

        public Builder withFormulaTypeName(String formulaTypeName) {

            this.formulaTypeName = formulaTypeName;
            return this;
        }

        public Builder withAge(int age) {

            this.age = age;
            return this;
        }

        public Builder withNumberOfMiles(long numberOfMiles) {

            this.numberOfMiles = numberOfMiles;
            return this;
        }

        public Builder withDiesel(boolean isDiesel) {

            this.isDiesel = isDiesel;
            return this;
        }

        public VehicleInfo build() {

            return new VehicleInfo(id, vehicleTypeName, formulaTypeName, age, numberOfMiles, isDiesel);
        }
    }
}
