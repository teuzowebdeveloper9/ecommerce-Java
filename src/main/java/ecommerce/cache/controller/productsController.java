package ecommerce.cache.controller;

import ecommerce.cache.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class productsController {
    private final ProductService productService;

    public productsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
}
