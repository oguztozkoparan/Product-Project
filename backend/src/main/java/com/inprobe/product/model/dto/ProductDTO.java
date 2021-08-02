package com.inprobe.product.model.dto;

import com.inprobe.product.model.entity.Product;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductDTO {

    @Min(value = 0, message = "Product id must be greater than or equal to 0")
    private long id;
    @NotBlank(message = "Product name is mandatory")
    private String name;
    @DecimalMin(value = "0.00", inclusive = false, message = "Product price must be greater than 0.00")
    private double price;
    private String imageUrl;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        return product;
    }
}
