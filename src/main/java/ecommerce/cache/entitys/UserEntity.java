package ecommerce.cache.entitys;

import ecommerce.cache.repositories.ProductsRepositories;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private List<ProductsEntity> orders;

    private final ProductsEntity productsEntity;
    private final ProductsRepositories productsRepositories;

    public UserEntity(ProductsEntity productsEntity, ProductsRepositories productsRepositories) {
        this.productsEntity = productsEntity;
        this.productsRepositories = productsRepositories;
    }

    public void addOrder(UUID idProduct) {
        ProductsEntity wanted = productsRepositories.findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + idProduct));

        this.orders.add(wanted);
    }
}
