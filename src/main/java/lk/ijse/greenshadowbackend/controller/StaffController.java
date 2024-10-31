package lk.ijse.greenshadowbackend.controller;

import jakarta.validation.Valid;
import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lk.ijse.greenshadowbackend.dto.StaffDTO;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.service.StaffBo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/staff")
public class StaffController {

    private final StaffBo staffBo;

    @PostMapping
    public ResponseEntity<?> saveStaff(@Valid @RequestBody StaffDTO staffDTO){
        try {
            System.out.println("StaffDTO: " + staffDTO);
            staffBo.saveStaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffResponse> getStaff(@PathVariable String id){
        try {
            return new ResponseEntity<>(staffBo.getStaff(id), HttpStatus.OK);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
