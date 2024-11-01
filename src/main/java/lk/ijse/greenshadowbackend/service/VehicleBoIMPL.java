package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.VehicleRepository;
import lk.ijse.greenshadowbackend.dto.VehicleDTO;
import lk.ijse.greenshadowbackend.entity.Vehicle;
import lk.ijse.greenshadowbackend.exception.AlreadyExistsException;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleBoIMPL implements VehicleBo {

    private final VehicleRepository vehicleRepository;
    private final Mapping mapping;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO){
        String vehicleCode = AppUtil.createVehicleCode();
        vehicleDTO.setVehicleCode(vehicleCode);
        if (vehicleRepository.existsByLicensePlateNumber(vehicleDTO.getLicensePlateNumber())){
            throw new AlreadyExistsException("vehicle plate number already used");
        }else {
            Vehicle save = vehicleRepository.save(mapping.convertVehicleDTOToVehicle(vehicleDTO));
            if (save == null){
                throw new DataPersistFailedException("vehicle save failed");
            }
        }
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleDTO.getVehicleCode())
                .orElseThrow(() -> new NotFoundException("vehicle not found"));

        vehicle.setStatus(vehicleDTO.getStatus());
        vehicle.setRemarks(vehicleDTO.getRemarks());

        if (vehicleDTO.getStaff() != null) {
            vehicle.setStaff(mapping.convertStaffDTOToStaff(vehicleDTO.getStaff()));
        }else{
            vehicle.setStaff(null);
        }

        vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleDTO getVehicle(String vehicleCode) {
        Vehicle vehicle = vehicleRepository.findById(vehicleCode)
                .orElseThrow(() -> new NotFoundException("vehicle not found"));

        return mapping.convertVehicleToVehicleDTO(vehicle);
    }

    @Override
    public void deleteVehicle(String vehicleCode) {
        Vehicle vehicle = vehicleRepository.findById(vehicleCode)
                .orElseThrow(() -> new NotFoundException("vehicle not found"));
        vehicleRepository.delete(vehicle);
    }


}
