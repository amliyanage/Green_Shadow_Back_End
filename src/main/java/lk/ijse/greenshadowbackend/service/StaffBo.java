package lk.ijse.greenshadowbackend.service;

import jakarta.validation.Valid;
import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lk.ijse.greenshadowbackend.dto.StaffDTO;

import java.util.List;

public interface StaffBo {
    void saveStaff(StaffDTO staffDTO);

    StaffResponse getStaff(String id);

    void updateStaff(@Valid StaffDTO staffDTO);

    void deleteStaff(String id);

    List<StaffDTO> getAllStaff();
}
