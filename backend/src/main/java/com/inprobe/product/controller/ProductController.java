package com.inprobe.product.controller;

import com.inprobe.product.model.dto.ProductDTO;
import com.inprobe.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        productServiceImpl.test();
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<ProductDTO> getProducts() {
        return productServiceImpl.getProducts();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ProductDTO getProductById(@PathVariable long id) {
        return productServiceImpl.getProduct(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO product) {
        return productServiceImpl.createProduct(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public ProductDTO updateProduct(@Valid @RequestBody ProductDTO product) {
        return productServiceImpl.updateProduct(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ProductDTO deleteProduct(@PathVariable long id) {
        return productServiceImpl.deleteProduct(id);
    }

}
