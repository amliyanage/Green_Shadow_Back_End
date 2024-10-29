package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.service.CropDetailsBo;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/cropDetails")
@RequiredArgsConstructor
public class CropDetailsController {

    private final CropDetailsBo cropDetailsBo;

    @PostMapping
    public ResponseEntity<?> saveCropDetails(
            @RequestPart(value = "logDetails") String logDetails,
            @RequestPart(value = "observedImg") MultipartFile observedImg
    ) {
        try {
            String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(observedImg);
            CropDetailsDTO cropDetailsDTO = new CropDetailsDTO();
            cropDetailsDTO.setLogDate(new Date());
            cropDetailsDTO.setLogDetails(logDetails);
            cropDetailsDTO.setObservedImage(updateBase64ProfilePic);
            cropDetailsBo.saveCropDetails(cropDetailsDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
