package ecommerce.cache.controller;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productsController {
    private final ProductService productService;

    public productsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    List<ProductsEntity> ListAllUsers(){
        return productService.ListAllProducts();
    }

    @PostMapping("/")
    ResponseEntity<ProductsEntity> createProduct(@RequestBody @Valid ProductDTO productDTO){
        return productService.createdProduct(productDTO);
    }
}
