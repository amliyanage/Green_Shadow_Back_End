package lk.ijse.greenshadowbackend.controller;

import jakarta.validation.Valid;
import lk.ijse.greenshadowbackend.dto.UserDTO;
import lk.ijse.greenshadowbackend.exception.AlreadyExistsException;
import lk.ijse.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exception.NotFoundException;
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
            userBo.saveUser(user);
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

    //TODO: Implement the updateUser method
    @PatchMapping(value = "/{email}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTO user , @PathVariable("email") String email){
        try {
            userBo.updateUser(user,email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
