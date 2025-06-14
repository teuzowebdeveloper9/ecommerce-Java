package ecommerce.cache.entitys;

import ecommerce.cache.DTOS.ProductDTO;
import ecommerce.cache.enums.Categorie;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    private Integer stock;

    private boolean popular;

    @ManyToMany(mappedBy = "orders")
    private List<UserEntity> buyers = new ArrayList<>();

    public List<UserEntity> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<UserEntity> buyers) {
        this.buyers = buyers;
    }

    public ProductsEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public void addOnStock(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("this amount doesn't make sense");
        this.stock += quantity;
    }

    public void removeOnStock(int quantity){
        if(quantity > this.stock) throw  new IllegalArgumentException("you cannot remove more than stock");
        this.stock -= quantity;
    }

    public void ApplyDiscount(BigDecimal discount){
        BigDecimal half = this.price.multiply(BigDecimal.valueOf(0.5));
        if(discount.compareTo(half) > 0){
            throw  new IllegalArgumentException("this discount exceeds 50% of the product " + id);
        }

        this.price = this.price.subtract(discount);
    }

    public void brandPopular (){
        this.popular = true;
    }

    public void RemovePopular (){
        this.popular = false;
    }

}
