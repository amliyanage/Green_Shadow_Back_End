package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.CropResponse;
import lk.ijse.greenshadowbackend.dto.CropDTO;

public interface CropBo {
    void saveCrop(CropDTO cropDTO, String fieldCode);

    CropResponse getCrop(String id);
}
