package ecommerce.cache.repositories;

import ecommerce.cache.entitys.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductsRepositories extends JpaRepository<ProductsEntity, UUID> {


    List<ProductsEntity> findByPopularTrue();

}
