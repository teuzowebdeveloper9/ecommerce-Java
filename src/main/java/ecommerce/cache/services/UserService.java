package ecommerce.cache.services;

import ecommerce.cache.DTOS.UserDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.entitys.UserEntity;
import ecommerce.cache.repositories.ProductsRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final ProductsRepositories productsRepositories;
    private final UserEntity userEntity;

    public UserService(ProductsRepositories productsRepositories, UserEntity userEntity) {
        this.productsRepositories = productsRepositories;
        this.userEntity = userEntity;
    }

    public void addOrder(UUID idProduct){
        Optional<ProductsEntity> wanted = productsRepositories.findById(idProduct);
        if(wanted.isEmpty()){
            throw new  IllegalArgumentException("this product don't exist");
        }

        userEntity.getOrders().add(wanted.get());
    }

    public ResponseEntity<UserEntity> createUser(UserDTO userDTO){
        UserEntity newUser = new UserEntity();

        newUser.setEmail(userDTO.getEmail());
        newUser.setName(userDTO.getName());
        newUser.setOrders(userDTO.getOrders());

        return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    }



}
