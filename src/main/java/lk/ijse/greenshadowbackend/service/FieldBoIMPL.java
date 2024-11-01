package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.FieldRepository;
import lk.ijse.greenshadowbackend.dto.FieldDTO;
import lk.ijse.greenshadowbackend.entity.Field;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FieldBoIMPL implements FieldBo{

    private final FieldRepository fieldRepository;

    private final Mapping mapping;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        fieldDTO.setFieldCode(AppUtil.createFieldCode());
        Field save = fieldRepository.save(mapping.convertFieldDTOToField(fieldDTO));
        if (save == null){
            throw new DataPersistFailedException("Field save failed");
        }
    }

}
