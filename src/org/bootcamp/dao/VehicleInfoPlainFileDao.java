package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public final class VehicleInfoPlainFileDao extends VehicleInfoAbstractDao {

    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final String SEPARATOR = ";";

    public VehicleInfoPlainFileDao(String filePath) {

        super();
        final File inputFile = new File(filePath);

        try (final Scanner scanner = new Scanner(new FileInputStream(inputFile))) {

            while (scanner.hasNextLine()) {

                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);

                final VehicleInfo.Builder builder = VehicleInfo.builder();

                builder.withId(tokens[VEHICLE_ID])
                        .withVehicleTypeName(tokens[VEHICLE_TYPE])
                        .withFormulaTypeName(tokens[VEHICLE_FORMULA])
                        .withAge(Integer.parseInt(tokens[VEHICLE_AGE]))
                        .withNumberOfMiles(Long.parseLong(tokens[VEHICLE_MILES]))
                        .withDiesel(Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));

                final VehicleInfo vehicleInfo = builder.build();

                vehicleInfoMap.put(vehicleInfo.getId(), vehicleInfo);
            }

        } catch (Exception ex) {

            throw new IllegalStateException("Cannot create instance of class: " + this.getClass().getSimpleName());
        }
    }
}
