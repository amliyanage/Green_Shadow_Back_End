package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.StaffRepository;
import lk.ijse.greenshadowbackend.dto.StaffDTO;
import lk.ijse.greenshadowbackend.entity.Staff;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffBoIMPL implements StaffBo{

    private final StaffRepository staffRepository;

    private final Mapping mapping;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        String staffID = AppUtil.createStaffID();
        while (staffRepository.existsById(staffID)) {
            staffID = AppUtil.createStaffID();
        }
        staffDTO.setId(staffID);
        Staff save = staffRepository.save(mapping.convertStaffDTOToStaff(staffDTO));
        if (save == null){
            throw new DataPersistFailedException("Staff save failed");
        }
    }

}
