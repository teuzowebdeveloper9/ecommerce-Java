package ecommerce.cache.repositories;

import ecommerce.cache.entitys.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderReposiories extends JpaRepository<OrderEntity, UUID> {
}
