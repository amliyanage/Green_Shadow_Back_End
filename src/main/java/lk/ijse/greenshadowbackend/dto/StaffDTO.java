package lk.ijse.greenshadowbackend.dto;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private String joinedDate;
    private Date DOB;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private String role;
    private List<EquipmentDTO> equipment;
    private List<FieldDTO> fields;
    private List<VehicleDTO> vehicles;
    private CropDetailsDTO cropDetails;
}
