package org.bootcamp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.model.VehicleInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public final class VehicleInfoJsonFileDao extends VehicleInfoAbstractDao {

    public VehicleInfoJsonFileDao(String filePath) {

        super();

        final File inputFile = new File(filePath);
        final ObjectMapper objectMapper = new ObjectMapper();

        try (final InputStream inputStream = new FileInputStream(inputFile)) {

            final List<VehicleInfo> vehicleInfos = objectMapper.readValue(inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, VehicleInfo.class));

            vehicleInfos.forEach(vehicleInfo -> vehicleInfoMap.put(vehicleInfo.getId(), vehicleInfo));

        } catch (Exception ex) {
            throw new IllegalStateException("Cannot create instance of class: " + this.getClass().getSimpleName());
        }
    }
}
