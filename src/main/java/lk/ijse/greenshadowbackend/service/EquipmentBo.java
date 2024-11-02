package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.dto.EquipmentDTO;

import java.util.List;

public interface EquipmentBo {
    void saveEquipment(EquipmentDTO equipmentDTO);

    EquipmentResponse getEquipmentById(String equipmentId);

    void updateEquipment(EquipmentDTO equipmentDTO ,String staffId , String fieldCode);

    void deleteEquipment(String equipmentId);

    List getAllEquipment();
}