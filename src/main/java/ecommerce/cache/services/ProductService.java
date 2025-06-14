package ecommerce.cache.services;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.entitys.ProductsEntity;
import ecommerce.cache.repositories.ProductsRepositories;
import jakarta.persistence.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

   private final ProductsRepositories productsRepositories;

    public ProductService(ProductsRepositories productsRepositories) {
        this.productsRepositories = productsRepositories;
    }
    
    public ResponseEntity<ProductsEntity> createdProduct(ProductDTO productDTO){
        ProductsEntity newproduct = new ProductsEntity();

        newproduct.setCategorie(productDTO.getCategorie());
        newproduct.setPrice(productDTO.getPrice());
        newproduct.setPopular(productDTO.isPopular());
        newproduct.setStock(productDTO.getStock());

        if(productDTO.getStock() <= 0){
            throw new RuntimeException("YOU SHOULD NOT CREATE A PRODUCT WITHOUT STOCK");
        }

        newproduct.addOnStock(productDTO.getStock());

        ProductsEntity savedProduct = productsRepositories.save(newproduct);


        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

    }



    public List<ProductsEntity> ListAllProducts(){
        return productsRepositories.findAll();
    }



    @Caching
    public List<ProductsEntity> getPopularProducts() {
        return productsRepositories.findByPopularTrue();
    }

    @CacheEvict(value = "popular-products", allEntries = true)
    public void updateProductPopularity(UUID id, boolean isPopular) {
        ProductsEntity product = productsRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setPopular(isPopular);
        productsRepositories.save(product);
    }

}
