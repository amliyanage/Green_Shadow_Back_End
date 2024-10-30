package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;

public interface CropDetailsBo {
    void saveCropDetails(CropDetailsDTO cropDetailsDTO);

    void updateCropDetails(CropDetailsDTO cropDetailsDTO);

    CropDetailsResponse findCropDetailsByLogCode(String logCode);

    void deleteCropDetailsByLogCode(String logCode);
}
