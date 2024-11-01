package lk.ijse.greenshadowbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {

    private String fieldCode;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9 ]+$")
    private String fieldName;

    @NotBlank
    private Point fieldLocation;

    @Positive
    @NotBlank
    private double fieldSize;

    @NotNull
    private String image1;

    @NotNull
    private String image2;

    @NotNull
    private List<StaffDTO> staff;
}
