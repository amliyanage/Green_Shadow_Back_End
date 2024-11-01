package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.dto.EquipmentDTO;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.service.EquipmentBo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{equipmentId}")
    public ResponseEntity<?> getEquipmentById(@PathVariable String equipmentId) {
        logger.info("Received request to get equipment by ID: {}", equipmentId);

        try {
            logger.info("Successfully retrieved equipment with ID: {}", equipmentId);
            return new ResponseEntity<>(equipmentBo.getEquipmentById(equipmentId), HttpStatus.OK);
        } catch (DataPersistFailedException e) {
            logger.error("Failed to retrieve equipment due to data persistence issue: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while retrieving equipment: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        logger.info("Received request to update equipment: {}", equipmentDTO);

        try {
            equipmentBo.updateEquipment(equipmentDTO);
            logger.info("Successfully updated equipment with ID: {}", equipmentDTO.getEquipmentId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataPersistFailedException e) {
            logger.error("Failed to update equipment due to data persistence issue: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException e) {
            logger.error("Failed to update equipment due to not found issue: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while updating equipment: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{equipmentId}")
    public ResponseEntity<?> deleteEquipment(@PathVariable String equipmentId) {
        logger.info("Received request to delete equipment by ID: {}", equipmentId);

        try {
            equipmentBo.deleteEquipment(equipmentId);
            logger.info("Successfully deleted equipment with ID: {}", equipmentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.error("Failed to delete equipment due to not found issue: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while deleting equipment: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
