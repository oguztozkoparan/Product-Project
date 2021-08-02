package com.inprobe.product.service;

import com.inprobe.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();

    ProductDTO getProduct(long id);

    ProductDTO createProduct(ProductDTO product);

    ProductDTO updateProduct(ProductDTO product);

    ProductDTO deleteProduct(long id);

    void test();

}
