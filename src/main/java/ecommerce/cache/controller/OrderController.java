package ecommerce.cache.controller;

import ecommerce.cache.DTOS.OrderDto;
import ecommerce.cache.entitys.OrderEntity;
import ecommerce.cache.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<OrderEntity> getAllOrders(){
        return orderService.ListAllOrders();
    }

    @PostMapping("/")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody @Valid OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }
}
