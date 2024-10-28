package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.UserResponse;
import lk.ijse.greenshadowbackend.entity.User;

public interface UserBo {
    void saveUser(User user);

    UserResponse getUserByEmail(String email);

    void updateUser(User user);
}
