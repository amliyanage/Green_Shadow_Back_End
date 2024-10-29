package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;

public interface CropDetailsBo {
    void saveCropDetails(CropDetailsDTO cropDetailsDTO);

    void updateCropDetails(CropDetailsDTO cropDetailsDTO);
}
