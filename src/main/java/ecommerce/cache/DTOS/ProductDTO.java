package ecommerce.cache.DTOS;

import ecommerce.cache.enums.Categorie;


import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO {

    private BigDecimal price;

    private Categorie categorie;

    private Integer stock;

    private boolean popular;

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
