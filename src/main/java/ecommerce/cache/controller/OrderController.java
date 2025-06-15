package ecommerce.cache.controller;

import ecommerce.cache.DTOS.OrderDto;
import ecommerce.cache.entitys.OrderEntity;
import ecommerce.cache.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "This endpoint lists all created orders (consider that orders depend directly on users and products)", description = "this endpoint lists all created orders")
    @GetMapping("/")
    public List<OrderEntity> getAllOrders(){
        return orderService.ListAllOrders();
    }

    @Operation(summary = "this endpoint creates an order", description = "passing a UUID of an existing user and an existing product this endpoint will create an order")
    @PostMapping("/")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody @Valid OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }
}
