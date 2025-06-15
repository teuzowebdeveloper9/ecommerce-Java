package ecommerce.cache.controller;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "this endpoint lists all products", description = "This endpoint will show the products and their buyers through orders. It can return this due to the @JsonManagedReference annotation and unfortunately the user cannot do this for now, otherwise the API response would be recursive and would infinitely return the products and users (even if there is only one of each).")
    List<ProductsEntity> ListAllUsers(){
        return productService.ListAllProducts();
    }

    @Operation(summary = "this end point create product", description = "This endpoint can create a product when you pass a product DTO that is composed of a BigDecimal price. IN THIS CASE, you would pass something like 100.00 or 200.00 in this model, a Category. The available categories are homemade, gamer, beauty, household_appliances, collectibles,\n" +
            "innovation This was implemented because I intend to create a feature of trending categories that would automatically get this title according to an algorithm and this would have to be CACHED as well (this project is about caching). You also need to pass an Integer stock and finally boolean popular. Pass with true or false the boolean values are not strings.")
    @PostMapping("/")
    ResponseEntity<ProductsEntity> createProduct(@RequestBody @Valid ProductDTO productDTO){
        return productService.createdProduct(productDTO);
    }
}
