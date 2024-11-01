package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.EquipmentRepository;
import lk.ijse.greenshadowbackend.customObj.EquipmentErrorResponse;
import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.dto.EquipmentDTO;
import lk.ijse.greenshadowbackend.entity.Equipment;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentBoIMPL implements EquipmentBo {

    private final EquipmentRepository equipmentRepository;

    private final Mapping mapping;

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        equipmentDTO.setEquipmentId(AppUtil.createEquipmentCode());
        Equipment save = equipmentRepository.save(mapping.convertEquipmentDTOToEquipment(equipmentDTO));
        if (save == null) {
            throw new DataPersistFailedException("Equipment not saved");
        }
    }

    @Override
    public EquipmentResponse getEquipmentById(String equipmentId) {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        if (equipment.isPresent()){
            return mapping.convertEquipmentToEquipmentDTO(equipment.get());
        }else {
            return new EquipmentErrorResponse("Equipment not found", 404);
        }
    }

    @Override
    public void updateEquipment(EquipmentDTO equipmentDTO) {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentDTO.getEquipmentId());
        if (equipment.isPresent()){
            Equipment save = equipmentRepository.save(mapping.convertEquipmentDTOToEquipment(equipmentDTO));
            if (save == null){
                throw new DataPersistFailedException("Equipment update failed");
            }
        }else {
            throw new NotFoundException("Equipment not found");
        }
    }

}
