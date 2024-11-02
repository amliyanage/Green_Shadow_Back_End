package lk.ijse.greenshadowbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.entity.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO implements EquipmentResponse {

    private String equipmentId;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String equipmentType;

    @NotBlank
    private String status;
}
