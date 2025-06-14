package ecommerce.cache.controller;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ResponseEntity<ProductsEntity> createProduct(ProductDTO productDTO){
        return productService.createdProduct(productDTO);
    }
}
