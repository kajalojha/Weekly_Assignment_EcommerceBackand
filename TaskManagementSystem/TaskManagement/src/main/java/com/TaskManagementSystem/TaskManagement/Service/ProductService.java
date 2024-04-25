package com.TaskManagementSystem.TaskManagement.Service;

import com.TaskManagementSystem.TaskManagement.Repository.ProductRepository;
import com.TaskManagementSystem.TaskManagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    // to get all the products
    public List<Product> getProducts(ProductRepository productRepository){
        return productRepository.findAll();
    }
    // add new product
    public void addNewProduct(Product product){
        Optional<Product> productByName = productRepository.findProductByName(product.getProduct_name());
        if(productByName.isPresent()){
            throw new IllegalStateException("product is already exist...");
        }
        productRepository.save(product);
    }

    // delete product
    public  void deleteProduct(Integer id , ProductRepository productRepository1){
        boolean p = productRepository1.existsById(id);
        if(!p){
            throw new IllegalStateException("product not found..");
        }
        productRepository1.deleteById(id);
    }

    // find product by name
    public Optional<Product> findproductByName(String product_name , ProductRepository productRepository){
        return productRepository.findProductByName(product_name);
    }

    // delete all product
    public void deleteAllProduct(ProductRepository productRepository){
        productRepository.deleteAll();
    }

}
