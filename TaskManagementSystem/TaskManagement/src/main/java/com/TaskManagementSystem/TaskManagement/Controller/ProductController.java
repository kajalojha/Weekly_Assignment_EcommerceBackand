package com.TaskManagementSystem.TaskManagement.Controller;

import com.TaskManagementSystem.TaskManagement.Repository.ProductRepository;
import com.TaskManagementSystem.TaskManagement.Service.ProductService;
import com.TaskManagementSystem.TaskManagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    @Autowired
    public ProductController(ProductService productService ,ProductRepository productRepository){
        this.productRepository = productRepository;
        this.productService = productService;
    }

    // get products
    @GetMapping("/All")
    public List<Product> getProducts(){
        return productService.getProducts(productRepository);
    }

    // add new user
    @PostMapping("/add")
    public void addNewproduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    // delete all
    @DeleteMapping("all")
    public void deleteAllProduct(){
        productService.deleteAllProduct(productRepository);
    }

    // delete by id
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id,productRepository);
    }

    // find product by name
   @GetMapping(path = "/get/{product_name}")
   public Optional<Product> findProductByName(@PathVariable String productName){
        return productService.findproductByName(productName , productRepository);

   }

}
