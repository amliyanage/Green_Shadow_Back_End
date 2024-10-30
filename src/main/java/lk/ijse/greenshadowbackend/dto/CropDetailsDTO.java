package lk.ijse.greenshadowbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDetailsDTO implements CropDetailsResponse {
    private String logCode;
    private Date logDate;
    private String logDetails;
    private String observedImage;
//    private List<FieldDTO> fields;
//    private List<CropDTO> crops;
//    private List<StaffDTO> staff;
}
