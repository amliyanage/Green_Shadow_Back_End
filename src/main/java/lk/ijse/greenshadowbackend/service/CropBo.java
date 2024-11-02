package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.CropDTO;

public interface CropBo {
    void saveCrop(CropDTO cropDTO, String fieldCode);
}
