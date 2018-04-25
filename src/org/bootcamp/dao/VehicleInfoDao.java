package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;

import java.util.List;

public interface VehicleInfoDao {

    List<VehicleInfo> getAllVehicles();
    VehicleInfo getVehicleInfoById(String id);
}
