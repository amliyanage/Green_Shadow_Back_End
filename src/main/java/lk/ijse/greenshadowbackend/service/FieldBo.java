package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.FieldResponse;
import lk.ijse.greenshadowbackend.dto.FieldDTO;

import java.util.List;

public interface FieldBo {
    void saveField(FieldDTO fieldDTO);

    void updateField(FieldDTO fieldDTO);

    FieldResponse getField(String fieldCode);

    void deleteField(String fieldCode);

    List getAllFields();
}
