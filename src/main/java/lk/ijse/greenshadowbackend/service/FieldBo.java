package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.FieldDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FieldBo {
    void saveField(FieldDTO fieldDTO);

    void updateField(FieldDTO fieldDTO);

    FieldDTO getField(String fieldCode);

    void deleteField(String fieldCode);

    List getAllFields();
}
