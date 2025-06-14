package ecommerce.cache.services;

import ecommerce.cache.DTOS.OrderDto;
import ecommerce.cache.entitys.OrderEntity;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.entitys.UserEntity;
import ecommerce.cache.repositories.OrderReposiories;
import ecommerce.cache.repositories.ProductsRepositories;
import ecommerce.cache.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final ProductsRepositories productsRepositories;
    private final OrderReposiories orderReposiories;

    public OrderService(UserRepository userRepository, ProductsRepositories productsRepositories, OrderReposiories orderReposiories) {
        this.userRepository = userRepository;
        this.productsRepositories = productsRepositories;
        this.orderReposiories = orderReposiories;
    }

    public List<OrderEntity> ListAllOrders(){
        return orderReposiories.findAll();
    }

    public ResponseEntity<OrderEntity> createOrder(OrderDto orderDto){
        UserEntity userInterested = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND"));

        ProductsEntity productOfInterest = productsRepositories.findById(orderDto.getProductId())
                .orElseThrow(() -> new RuntimeException("PRODUCT NOT FOUND"));

        OrderEntity newOrder = new OrderEntity();

        newOrder.setProductId(productOfInterest.getId());
        newOrder.setUserId(userInterested.getId());

        userInterested.getOrders().add(productOfInterest);
        productOfInterest.getBuyers().add(userInterested);

        ProductsEntity productSaved = productsRepositories.save(productOfInterest);
       UserEntity userSaved = userRepository.save(userInterested);

      return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }


}
