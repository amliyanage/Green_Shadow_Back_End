package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.FieldDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface FieldBo {
    void saveField(FieldDTO fieldDTO);

    void updateField(FieldDTO fieldDTO);
}
