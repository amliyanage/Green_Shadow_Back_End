package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.dto.EquipmentDTO;

public interface EquipmentBo {
    void saveEquipment(EquipmentDTO equipmentDTO);

    EquipmentResponse getEquipmentById(String equipmentId);
}
