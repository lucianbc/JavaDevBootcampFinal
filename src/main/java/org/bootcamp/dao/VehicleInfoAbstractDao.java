package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

abstract class VehicleInfoAbstractDao implements VehicleInfoDao {

    protected final Map<String, VehicleInfo> vehicleInfoMap = new HashMap<>();

    protected VehicleInfoAbstractDao() {}

    @Override
    public List<VehicleInfo> getAllVehicles() {

        return new ArrayList<>(vehicleInfoMap.values());
    }

    @Override
    public VehicleInfo getVehicleInfoById(String id) {

        return vehicleInfoMap.get(id);
    }
}
