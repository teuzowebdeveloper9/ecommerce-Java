package ecommerce.cache.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ecommerce.cache.DTOS.UserDTO;
import ecommerce.cache.repositories.ProductsRepositories;
import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_orders",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonBackReference
    private List<ProductsEntity> orders;



    public UserEntity(String name, String email, List<ProductsEntity> orders) {
        this.name = name;
        this.email = email;
        this.orders = orders;

    }

    public UserEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductsEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<ProductsEntity> orders) {
        this.orders = orders;
    }
}
