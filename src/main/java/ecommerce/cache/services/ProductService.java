package ecommerce.cache.services;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.repositories.ProductsRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProctService {

   private final ProductsRepositories productsRepositories;

    public ProctService(ProductsRepositories productsRepositories) {
        this.productsRepositories = productsRepositories;
    }

    public ResponseEntity<ProductsEntity> createdProduct(ProductDTO productDTO){
        ProductsEntity newproduct = new ProductsEntity();

        newproduct.setCategorie(productDTO.getCategorie());
        newproduct.setPrice(productDTO.getPrice());
        newproduct.setPopular(productDTO.isPopular());
        newproduct.setStock(productDTO.getStock());

        ProductsEntity savedProduct = productsRepositories.save(newproduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

    }

}
