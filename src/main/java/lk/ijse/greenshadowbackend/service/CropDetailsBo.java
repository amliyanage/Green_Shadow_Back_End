package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;

import java.util.List;

public interface CropDetailsBo {
    void saveCropDetails(CropDetailsDTO cropDetailsDTO);

    void updateCropDetails(CropDetailsDTO cropDetailsDTO , String logCode);

    CropDetailsResponse findCropDetailsByLogCode(String logCode);

    void deleteCropDetailsByLogCode(String logCode);

    List<CropDetailsDTO> getAllCropDetails();
}
