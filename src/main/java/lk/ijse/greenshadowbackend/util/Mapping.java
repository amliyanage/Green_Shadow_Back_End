package lk.ijse.greenshadowbackend.util;

import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;
import lk.ijse.greenshadowbackend.dto.StaffDTO;
import lk.ijse.greenshadowbackend.dto.UserDTO;
import lk.ijse.greenshadowbackend.dto.VehicleDTO;
import lk.ijse.greenshadowbackend.entity.CropDetails;
import lk.ijse.greenshadowbackend.entity.Staff;
import lk.ijse.greenshadowbackend.entity.User;
import lk.ijse.greenshadowbackend.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper mapper;

    public User convertUserDTOToUser(UserDTO userDTO){
        return mapper.map(userDTO, User.class);
    }

    public UserDTO convertUserToUserDTO(User user){
        return mapper.map(user, UserDTO.class);
    }

    public CropDetails convertCropDetailsDTOToCropDetails(CropDetailsDTO cropDetailsDTO){
        return mapper.map(cropDetailsDTO, CropDetails.class);
    }

    public CropDetailsDTO convertCropDetailsToCropDetailsDTO(CropDetails cropDetails){
        return mapper.map(cropDetails, CropDetailsDTO.class);
    }

    public List convertCropDetailsListToCropDetailsDTOList(List<CropDetails> cropDetails){
        return mapper.map(cropDetails, List.class);
    }

    public StaffDTO convertStaffToStaffDTO(Staff staff){
        return mapper.map(staff, StaffDTO.class);
    }

    public Staff convertStaffDTOToStaff(StaffDTO staffDTO){
        return mapper.map(staffDTO, Staff.class);
    }

    public List convertStaffListToStaffDTOList(List<Staff> all) {
        return mapper.map(all, List.class);
    }

    public Vehicle convertVehicleDTOToVehicle(VehicleDTO vehicleDTO){
        return mapper.map(vehicleDTO, Vehicle.class);
    }

    public VehicleDTO convertVehicleToVehicleDTO(Vehicle vehicle) {
        return mapper.map(vehicle, VehicleDTO.class);
    }
}
