package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.CropDetailsRepository;
import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;
import lk.ijse.greenshadowbackend.entity.CropDetails;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
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

}
