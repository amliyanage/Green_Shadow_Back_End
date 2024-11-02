package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.dto.FieldDTO;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.service.FieldBo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/field")
public class FieldController {

    private static final Logger logger = LoggerFactory.getLogger(FieldController.class);
    private final FieldBo fieldBo;

    @PostMapping
    public ResponseEntity<?> saveField(@RequestBody FieldDTO fieldDTO){
        logger.info("Request received to save a new field: {}", fieldDTO);
        try {
            fieldBo.saveField(fieldDTO);
            logger.info("Field saved successfully: {}", fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            logger.error("Failed to save field: {}", fieldDTO, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while saving field: {}", fieldDTO, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(params = "staffIds")
    public ResponseEntity<?> updateField(@RequestBody FieldDTO fieldDTO, @RequestParam("staffIds") List<String> staffIds){
        logger.info("Request received to update field with staff IDs {}: {}", staffIds, fieldDTO);
        try {
            fieldBo.updateField(fieldDTO,staffIds);
            logger.info("Field updated successfully: {}", fieldDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.error("Field not found for update: {}", fieldDTO, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while updating field: {}", fieldDTO, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{fieldCode}")
    public ResponseEntity<?> getField(@PathVariable String fieldCode){
        logger.info("Request received to get field with code: {}", fieldCode);
        try {
            var field = fieldBo.getField(fieldCode);
            logger.info("Field retrieved successfully: {}", field);
            return new ResponseEntity<>(field, HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.error("Field not found with code: {}", fieldCode, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while retrieving field with code: {}", fieldCode, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{fieldCode}")
    public ResponseEntity<?> deleteField(@PathVariable String fieldCode){
        logger.info("Request received to delete field with code: {}", fieldCode);
        try {
            fieldBo.deleteField(fieldCode);
            logger.info("Field deleted successfully with code: {}", fieldCode);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.error("Field not found for deletion with code: {}", fieldCode, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while deleting field with code: {}", fieldCode, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllFields(){
        logger.info("Request received to get all fields");
        try {
            var fields = fieldBo.getAllFields();
            logger.info("All fields retrieved successfully");
            return new ResponseEntity<>(fields, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Internal server error while retrieving all fields", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
