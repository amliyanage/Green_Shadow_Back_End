package lk.ijse.greenshadowbackend.dto.impl;

import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lk.ijse.greenshadowbackend.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDetailsDTO implements CropDetailsResponse , SuperDto {
    private String logCode;
    private Date logDate;
    private String logDetails;
    private String observedImage;
    private List<String> fieldCodes;
    private List<String> cropCodes;
    private List<String> staffIds;
}
