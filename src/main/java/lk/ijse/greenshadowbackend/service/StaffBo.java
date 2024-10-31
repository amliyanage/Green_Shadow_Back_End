package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lk.ijse.greenshadowbackend.dto.StaffDTO;

public interface StaffBo {
    void saveStaff(StaffDTO staffDTO);

    StaffResponse getStaff(String id);
}
