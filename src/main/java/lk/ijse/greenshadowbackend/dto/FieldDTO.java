package lk.ijse.greenshadowbackend.dto;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.entity.Crop;
import lk.ijse.greenshadowbackend.entity.CropDetails;
import lk.ijse.greenshadowbackend.entity.Equipment;
import lk.ijse.greenshadowbackend.entity.Staff;
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
    private String fieldName;
    private Point fieldLocation;
    private double fieldSize;
    private String image1;
    private String image2;
    private List<StaffDTO> staff;
}
