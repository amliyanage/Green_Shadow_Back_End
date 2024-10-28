package lk.ijse.greenshadowbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private String equipmentId;
    private String name;
    private String equipmentType;
    private String status;
    private StaffDTO assignedStaffDetails;
    private FieldDTO assignedFieldDetails;
}
