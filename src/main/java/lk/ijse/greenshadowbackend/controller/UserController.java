package lk.ijse.greenshadowbackend.controller;

import jakarta.validation.Valid;
import lk.ijse.greenshadowbackend.dto.UserDTO;
import lk.ijse.greenshadowbackend.exception.AlreadyExistsException;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.UserNotFoundException;
import lk.ijse.greenshadowbackend.service.UserBo;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserBo userBo;

    private final Mapping mapping;

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO user) {
        try {
            userBo.saveUser(mapping.convertUserDTOToUser(user));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (AlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userBo.getUserByEmail(email), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTO user) {
        try {
            userBo.updateUser(mapping.convertUserDTOToUser(user));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
