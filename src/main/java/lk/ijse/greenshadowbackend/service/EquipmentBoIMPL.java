package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.EquipmentRepository;
import lk.ijse.greenshadowbackend.dto.EquipmentDTO;
import lk.ijse.greenshadowbackend.entity.Equipment;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
