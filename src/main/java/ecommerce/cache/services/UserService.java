package ecommerce.cache.services;

import ecommerce.cache.DTOS.UserDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.entitys.UserEntity;
import ecommerce.cache.repositories.ProductsRepositories;
import ecommerce.cache.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final ProductsRepositories productsRepositories;
    private final UserRepository userRepository;

    public UserService(ProductsRepositories productsRepositories, UserRepository userRepository) {
        this.productsRepositories = productsRepositories;
        this.userRepository = userRepository;
    }
    public void addOrder(UUID userId, UUID idProduct) {
        ProductsEntity wanted = productsRepositories.findById(idProduct)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        user.getOrders().add(wanted);
        userRepository.save(user);
    }

    public ResponseEntity<UserEntity> createUser(UserDTO userDTO){
        UserEntity newUser = new UserEntity();

        newUser.setEmail(userDTO.getEmail());
        newUser.setName(userDTO.getName());
        newUser.setOrders(userDTO.getOrders());

        UserEntity savedUser = userRepository.save(newUser);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }



}
