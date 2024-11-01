package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.VehicleDTO;

import java.util.List;

public interface VehicleBo {
    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    VehicleDTO getVehicle(String vehicleCode);

    void deleteVehicle(String vehicleCode);

    List getAllVehicles();
}
