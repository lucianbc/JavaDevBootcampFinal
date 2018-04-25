package org.bootcamp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.model.VehicleInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Component
@Profile("jsondb")
public final class VehicleInfoJsonFileDao extends VehicleInfoAbstractDao {

    @Value("${filepath}")
    private String filePath;

    @PostConstruct
    public void init() {
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

    public VehicleInfoJsonFileDao() {
        super();
    }
}
