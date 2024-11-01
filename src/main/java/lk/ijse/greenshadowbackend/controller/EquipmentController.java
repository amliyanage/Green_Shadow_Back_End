package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.dto.EquipmentDTO;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.service.EquipmentBo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);
    private final EquipmentBo equipmentBo;

    @PostMapping
    public ResponseEntity<?> saveEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        logger.info("Received request to save equipment: {}", equipmentDTO);

        try {
            equipmentBo.saveEquipment(equipmentDTO);
            logger.info("Successfully saved equipment with ID: {}", equipmentDTO.getEquipmentId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            logger.error("Failed to save equipment due to data persistence issue: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while saving equipment: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
