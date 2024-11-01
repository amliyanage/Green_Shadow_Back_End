package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.VehicleDTO;

public interface VehicleBo {
    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);
}
