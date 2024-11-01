package lk.ijse.greenshadowbackend.dto;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.entity.Field;
import lk.ijse.greenshadowbackend.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO implements EquipmentResponse {
    private String equipmentId;
    private String name;
    private String equipmentType;
    private String status;
    private Field field;
    private Staff staff;
}
