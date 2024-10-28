package lk.ijse.greenshadowbackend.dto;

import lk.ijse.greenshadowbackend.entity.CropDetails;
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
    private List<CropDTO> crops;
    private List<StaffDTO> staff;
    private String image1;
    private String image2;
    private List<EquipmentDTO> equipment;
    private CropDetails cropDetails;
}
