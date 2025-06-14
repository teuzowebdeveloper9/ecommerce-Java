package ecommerce.cache.services;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.entitys.ProductsEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProctService {

    public ResponseEntity<ProductsEntity> createdProduct(ProductDTO productDTO){
        ProductsEntity newproduct = new ProductsEntity();

        newproduct.setCategorie(productDTO.getCategorie());
        newproduct.setPrice(productDTO.getPrice());
        newproduct.setPopular(productDTO.isPopular());
        newproduct.setStock(productDTO.getStock());


        return ResponseEntity.status(HttpStatus.CREATED).body(newproduct);

    }

}
