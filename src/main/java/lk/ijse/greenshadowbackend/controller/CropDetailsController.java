package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.service.CropDetailsBo;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cropDetails")
@RequiredArgsConstructor
public class CropDetailsController {

    private final CropDetailsBo cropDetailsBo;

    @PostMapping
    public ResponseEntity<?> saveCropDetails(
            @RequestPart(value = "logDetails") String logDetails,
            @RequestPart(value = "observedImg") MultipartFile observedImg,
            @RequestParam(value = "fieldCode") List<String> fieldCodes,
            @RequestParam(value = "cropCode") List<String> cropCodes,
            @RequestParam(value = "staffId") List<String> staffIds
            ) {
        try {
            String updateBase64ProfilePic = AppUtil.toBase64(observedImg);
            CropDetailsDTO cropDetailsDTO = new CropDetailsDTO();
            cropDetailsDTO.setLogDate(new Date());
            cropDetailsDTO.setLogDetails(logDetails);
            cropDetailsDTO.setObservedImage(updateBase64ProfilePic);
            cropDetailsBo.saveCropDetails(cropDetailsDTO,fieldCodes,cropCodes,staffIds);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/{logCode}")
    public ResponseEntity<?> updateCropDetails(
            @RequestPart(value = "logDetails") String logDetails,
            @RequestPart(value = "observedImg") MultipartFile observedImg,
            @PathVariable(value = "logCode") String logCode
    ){
        try {
            String updateBase64ProfilePic = AppUtil.toBase64(observedImg);
            CropDetailsDTO cropDetailsDTO = new CropDetailsDTO();
            cropDetailsDTO.setLogDetails(logDetails);
            cropDetailsDTO.setObservedImage(updateBase64ProfilePic);
            cropDetailsBo.updateCropDetails(cropDetailsDTO,logCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{logCode}")
    public ResponseEntity<?> findCropDetailsByLogCode(@PathVariable String logCode){
        try {
            CropDetailsResponse cropDetailsByLogCode = cropDetailsBo.findCropDetailsByLogCode(logCode);
            return new ResponseEntity<>(cropDetailsByLogCode, HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{logCode}")
    public ResponseEntity<?> deleteCropDetailsByLogCode(@PathVariable String logCode){
        try {
            cropDetailsBo.deleteCropDetailsByLogCode(logCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCropDetails(){
        return new ResponseEntity<>(cropDetailsBo.getAllCropDetails(), HttpStatus.OK);
    }

}
