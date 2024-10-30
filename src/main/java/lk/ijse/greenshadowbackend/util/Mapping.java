package lk.ijse.greenshadowbackend.util;

import lk.ijse.greenshadowbackend.dto.CropDetailsDTO;
import lk.ijse.greenshadowbackend.dto.UserDTO;
import lk.ijse.greenshadowbackend.entity.CropDetails;
import lk.ijse.greenshadowbackend.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper mapper;

    public User convertUserDTOToUser(UserDTO userDTO){
        return mapper.map(userDTO, User.class);
    }

    public UserDTO convertUserToUserDTO(User user){
        return mapper.map(user, UserDTO.class);
    }

    public CropDetails convertCropDetailsDTOToCropDetails(CropDetailsDTO cropDetailsDTO){
        return mapper.map(cropDetailsDTO, CropDetails.class);
    }

    public CropDetailsDTO convertCropDetailsToCropDetailsDTO(CropDetails cropDetails){
        return mapper.map(cropDetails, CropDetailsDTO.class);
    }

    public List convertCropDetailsListToCropDetailsDTOList(List<CropDetails> cropDetails){
        return mapper.map(cropDetails, List.class);
    }

}
