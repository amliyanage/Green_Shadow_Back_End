package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.UserResponse;
import lk.ijse.greenshadowbackend.dto.impl.UserDTO;

public interface UserBo {
    void saveUser(UserDTO user);

    UserResponse getUserByEmail(String email);

    void updateUser(UserDTO user , String email);
}
