package org.bootcamp.service;

import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;
import org.bootcamp.model.VehicleInfo;

final class ConversionUtils {

    private ConversionUtils() {}

    static Vehicle getVehicle(VehicleInfo vehicleInfo) {

        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        final String vehicleName = vehicleInfo.getVehicleTypeName();
        final int age = vehicleInfo.getAge();
        final long numberOfMiles = vehicleInfo.getNumberOfMiles();
        final boolean isDiesel = vehicleInfo.isDiesel();

        if (vehicleName.equals(carClassName)) {

            return new Car(age, numberOfMiles, isDiesel);
        }

        if (vehicleName.equals(busClassName)) {

            return new Bus(age, numberOfMiles, isDiesel);
        }

        if (vehicleName.equals(tipperClassName)) {

            return new Tipper(age, numberOfMiles, isDiesel);
        }

        return null;
    }
}
