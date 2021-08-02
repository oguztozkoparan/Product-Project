package com.inprobe.product.service;

import com.inprobe.product.exception.NotFoundException;
import com.inprobe.product.model.dto.ProductDTO;
import com.inprobe.product.model.entity.Product;
import com.inprobe.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream().map(Product::toProductDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get().toProductDTO();
        } else {
            throw new NotFoundException("Product not found with id:" + id);
        }
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        if (product.getId() > 0) {
            throw new RuntimeException("Product already exists");
        }

        Product createdProduct = productRepository.save(product.toProduct());
        return createdProduct.toProductDTO();
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDto) {
        Optional<Product> product = productRepository.findById(productDto.getId());
        if (product.isPresent()) {
            Product createdProduct = productRepository.save(productDto.toProduct());
            return createdProduct.toProductDTO();
        } else {
            throw new NotFoundException("Product not found with id:" + productDto.getId());
        }
    }

    @Override
    public ProductDTO deleteProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product tobedeletedProduct = product.get();
            productRepository.delete(tobedeletedProduct);
            return tobedeletedProduct.toProductDTO();
        } else {
            throw new NotFoundException("Product not found with id:" + id);
        }
    }

    @Override
    public void test() {
        Product p = productRepository.getById(12l);
        System.out.println("1->" + p.getName());
        p.setName("test name");
        System.out.println("2->" + p.getName());
        productRepository.save(p);
        productRepository.flush();

        System.out.println("3->" + p.getName());
        p.setName("test name2");
        System.out.println("4->" + p.getName());
        productRepository.save(p);
        System.out.println("5->" + p.getName());
        productRepository.flush();
        System.out.println("6->" + p.getName());
    }
}
