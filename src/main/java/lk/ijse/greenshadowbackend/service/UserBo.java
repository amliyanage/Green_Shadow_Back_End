package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.UserResponse;
import lk.ijse.greenshadowbackend.dto.UserDTO;
import lk.ijse.greenshadowbackend.entity.User;

public interface UserBo {
    void saveUser(UserDTO user);

    UserResponse getUserByEmail(String email);

    void updateUser(UserDTO user , String email);
}
