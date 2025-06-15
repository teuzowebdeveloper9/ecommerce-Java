package ecommerce.cache.controller;


import ecommerce.cache.DTOS.UserDTO;
import ecommerce.cache.entitys.UserEntity;
import ecommerce.cache.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "this endpoint lists all users ",description = "When accessing this endpoint, all created users will be listed (products purchased in this version are not yet shown. I am creating a DTOS response for this. For now, only the products route shows its relationship because it is marked with @JsonManagedReference)")
    @GetMapping("/")
    List<UserEntity> ListAllUsers(){
        return userService.ListAllUser();
    }

    @Operation(summary = "this endpoint create and return one user", description = "when you pass a user DTO to this route that is composed of a String name a String email AND A List<ProductsEntity> orders I would advise starting with NULL but it has already worked with an empty array ([ ]) but I would advise starting with null because for me it is the best way to represent the absence of anything and you will not be able to put something in the creation (I have already tried) and even when putting it through an order because of the @JsonBackReference annotation it will not appear but I am understanding responses DTOS and soon this problem will not exist")
    @PostMapping("/")
    ResponseEntity<UserEntity> createUsers(@RequestBody @Valid UserDTO userDTO){
        return userService.createUser(userDTO);
    }
}
