package ecommerce.cache.controller;


import ecommerce.cache.DTOS.UserDTO;
import ecommerce.cache.entitys.UserEntity;
import ecommerce.cache.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    List<UserEntity> ListAllUsers(){
        return userService.ListAllUser();
    }

    @PostMapping("/")
    ResponseEntity<UserEntity> createUsers(@RequestBody @Valid UserDTO userDTO){
        return userService.createUser(userDTO);
    }
}
