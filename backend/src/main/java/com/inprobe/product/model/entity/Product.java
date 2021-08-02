package com.inprobe.product.model.entity;

import com.inprobe.product.model.dto.ProductDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products_oguz")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;
    private String imageUrl;

    public ProductDTO toProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.getName());
        productDTO.setPrice(this.getPrice());
        productDTO.setImageUrl(this.getImageUrl());
        return productDTO;
    }

}
