package ecommerce.cache.DTOS;

import java.util.UUID;

public class OrderDto {

    private UUID UserId;

    private UUID ProductId;

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public UUID getProductId() {
        return ProductId;
    }

    public void setProductId(UUID productId) {
        ProductId = productId;
    }
}
