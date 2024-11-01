package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.FieldRepository;
import lk.ijse.greenshadowbackend.dto.FieldDTO;
import lk.ijse.greenshadowbackend.entity.Field;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateField(FieldDTO fieldDTO) {
        Optional<Field> field = fieldRepository.findById(fieldDTO.getFieldCode());

        if (field.isPresent()) {
            fieldRepository.save(mapping.convertFieldDTOToField(fieldDTO));
        }else {
            throw new NotFoundException("Field not found");
        }
    }

    @Override
    public FieldDTO getField(String fieldCode) {
        Optional<Field> field = fieldRepository.findById(fieldCode);
        if (field.isPresent()) {
            return mapping.convertFieldToFieldDTO(field.get());
        }else {
            throw new NotFoundException("Field not found");
        }
    }

    @Override
    public void deleteField(String fieldCode) {
        Optional<Field> field = fieldRepository.findById(fieldCode);
        if (field.isPresent()) {
            fieldRepository.deleteById(fieldCode);
        }else {
            throw new NotFoundException("Field not found");
        }
    }

    @Override
    public List getAllFields() {
        return mapping.convertFieldListToFieldDTOList(fieldRepository.findAll());
    }

}
