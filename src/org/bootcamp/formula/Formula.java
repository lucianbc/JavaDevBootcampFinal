package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public enum Formula {

    CAR_BASIC_FORMULA {

        @Override
        public float calculate(Vehicle vehicle) {

            float cost = 100.0f * vehicle.getAge();
            cost += ((vehicle.isDiesel()) ? 500.0f : 0.0f);
            cost += ((vehicle.getNumberOfMiles() > 200000) ? 500.0f : 0.0f);
            return cost;
        }
    },

    BUS_BASIC_FORMULA {

        @Override
        public float calculate(Vehicle vehicle) {

            float cost = 200.0f * vehicle.getAge();
            cost += ((vehicle.isDiesel()) ? 1000.0f : 0.0f);

            if (vehicle.getNumberOfMiles() > 200000)
                cost += 1000.0f;
            else if (vehicle.getNumberOfMiles() > 100000)
                cost += 500.0f;

            return cost;
        }
    },

    TIPPER_BASIC_FORMULA {

        @Override
        public float calculate(Vehicle vehicle) {

            float cost = 300.0f * vehicle.getAge();

            cost += ((vehicle.getNumberOfMiles() > 80000) ? 700.0f : 0.0f);
            return cost;
        }
    },

    CAR_CHRISTMAS_FORMULA {

        @Override
        public float calculate(Vehicle vehicle) {

            return CAR_BASIC_FORMULA.calculate(vehicle) * 0.95f;
        }
    },

    BUS_CHRISTMAS_FORMULA {

        @Override
        public float calculate(Vehicle vehicle) {

            return BUS_BASIC_FORMULA.calculate(vehicle) * 0.90f;
        }
    },

    TIPPER_CHRISTMAS_FORMULA {

        @Override
        public float calculate(Vehicle vehicle) {

            return TIPPER_BASIC_FORMULA.calculate(vehicle) * 0.85f;
        }
    };

    public abstract float calculate(Vehicle vehicle);
}
