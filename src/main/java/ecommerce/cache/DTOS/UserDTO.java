package ecommerce.cache.DTOS;

import ecommerce.cache.entitys.ProductsEntity;

import java.util.List;

public class UserDTO {

    private String name;

    private String email;

    private List<ProductsEntity> orders;

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
