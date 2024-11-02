package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.StaffRepository;
import lk.ijse.greenshadowbackend.customObj.StaffErrorResponse;
import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lk.ijse.greenshadowbackend.dto.StaffDTO;
import lk.ijse.greenshadowbackend.entity.Staff;
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

    @Override
    public StaffResponse getStaff(String id) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()){
            return mapping.convertStaffToStaffDTO(staff.get());
        }else {
            return new StaffErrorResponse(404, "Staff not found");
        }
    }

    @Override
    public void updateStaff(StaffDTO staffDTO,String id) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()){
            staffDTO.setId(id);
            Staff save = staffRepository.save(mapping.convertStaffDTOToStaff(staffDTO));
            if (save == null){
                throw new DataPersistFailedException("Staff update failed");
            }
        }else {
            throw new NotFoundException("Staff not found");
        }
    }

    @Override
    public void deleteStaff(String id) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()){
            staffRepository.deleteById(id);
        }else {
            throw new NotFoundException("Staff not found");
        }
    }

    @Override
    public List getAllStaff() {
        return mapping.convertStaffListToStaffDTOList(staffRepository.findAll());
    }

}
