package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.Repository.UserRepository;
import lk.ijse.greenshadowbackend.customObj.UserErrorResponse;
import lk.ijse.greenshadowbackend.customObj.UserResponse;
import lk.ijse.greenshadowbackend.entity.User;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserBoIMPL implements UserBo{

    private final UserRepository userRepository;

    private final Mapping mapping;

    @Override
    public void saveUser(User user) {
        Optional<User> existsUser = userRepository.findByEmail(user.getEmail());
        if (!existsUser.isPresent()) {
            User save = userRepository.save(user);
            if (save == null) {
                throw new DataPersistFailedException("User save failed");
            }
        }else {
            throw new DataPersistFailedException("User already exists");
        }
    }

}