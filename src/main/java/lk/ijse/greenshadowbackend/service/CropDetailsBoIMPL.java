package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.CropDetailsRepository;
import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lk.ijse.greenshadowbackend.customObj.CropErrorResponse;
import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;
import lk.ijse.greenshadowbackend.entity.CropDetails;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CropDetailsBoIMPL implements CropDetailsBo {

    private final CropDetailsRepository cropDetailsRepository;

    private final Mapping mapping;

    @Override
    public void saveCropDetails(CropDetailsDTO cropDetailsDTO) {
        String logCode = AppUtil.createCropDetailsID();
        while (cropDetailsRepository.existsByLogCode(logCode)) {
            logCode = AppUtil.createCropDetailsID();
        }
        cropDetailsDTO.setLogCode(logCode);
        CropDetails save = cropDetailsRepository.save(mapping.convertCropDetailsDTOToCropDetails(cropDetailsDTO));
        if (save == null){
            throw new DataPersistFailedException("Crop details save failed");
        }
    }

    @Override
    public void updateCropDetails(CropDetailsDTO cropDetailsDTO){
        Optional<CropDetails> cropDetailsByLogCode = cropDetailsRepository.findCropDetailsByLogCode(cropDetailsDTO.getLogCode());
        if (cropDetailsByLogCode.isPresent()){
            cropDetailsByLogCode.get().setLogDetails(cropDetailsDTO.getLogDetails());
            cropDetailsByLogCode.get().setObservedImage(cropDetailsDTO.getObservedImage());
        }else {
            throw new NotFoundException("Crop details not found");
        }
    }

    @Override
    public CropDetailsResponse findCropDetailsByLogCode(String logCode) {
        Optional<CropDetails> cropDetailsByLogCode = cropDetailsRepository.findCropDetailsByLogCode(logCode);
        if (cropDetailsByLogCode.isPresent()){
            CropDetailsDTO cropDetailsDTO = mapping.convertCropDetailsToCropDetailsDTO(cropDetailsByLogCode.get());
            return cropDetailsDTO;
        }else {
            return new CropErrorResponse(0,"Crop details not found");
        }
    }

    @Override
    public void deleteCropDetailsByLogCode(String logCode) {
        Optional<CropDetails> cropDetailsByLogCode = cropDetailsRepository.findCropDetailsByLogCode(logCode);
        if (cropDetailsByLogCode.isPresent()) {
            cropDetailsRepository.delete(cropDetailsByLogCode.get());
        }else {
            throw new NotFoundException("Crop details not found");
        }
    }

}
