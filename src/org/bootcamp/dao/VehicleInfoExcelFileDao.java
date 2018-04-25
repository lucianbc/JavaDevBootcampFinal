package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

public final class VehicleInfoExcelFileDao extends VehicleInfoAbstractDao {

    private static final int EXCEL_INFORMATION_SHEET = 0;
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;

    public VehicleInfoExcelFileDao(String filePath) {

        super();
        final File inputFile = new File(filePath);

        try (final InputStream inputStream = new FileInputStream(inputFile)) {

            final Workbook workbook = new XSSFWorkbook(inputStream);
            final Sheet dataTypeSheet = workbook.getSheetAt(EXCEL_INFORMATION_SHEET);
            final Iterator<Row> iterator = dataTypeSheet.iterator();

            while (iterator.hasNext()) {

                final Row currentRow = iterator.next();

                final VehicleInfo.Builder builder = VehicleInfo.builder();
                final int age = new Double(currentRow.getCell(VEHICLE_AGE).getNumericCellValue()).intValue();
                final long numberOfMiles = new Double(currentRow.getCell(VEHICLE_MILES).getNumericCellValue()).longValue();

                builder.withId(currentRow.getCell(VEHICLE_ID).getStringCellValue())
                        .withVehicleTypeName(currentRow.getCell(VEHICLE_TYPE).getStringCellValue())
                        .withFormulaTypeName(currentRow.getCell(VEHICLE_FORMULA).getStringCellValue())
                        .withAge(age)
                        .withNumberOfMiles(numberOfMiles)
                        .withDiesel(currentRow.getCell(VEHICLE_IS_DIESEL).getBooleanCellValue());

                final VehicleInfo vehicleInfo = builder.build();

                vehicleInfoMap.put(vehicleInfo.getId(), vehicleInfo);
            }

        } catch (Exception ex) {

            throw new IllegalStateException("Cannot create instance of class: " + this.getClass().getSimpleName());
        }
    }
}
