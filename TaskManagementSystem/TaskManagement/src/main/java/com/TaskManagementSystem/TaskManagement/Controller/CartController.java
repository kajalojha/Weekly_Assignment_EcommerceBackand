package com.TaskManagementSystem.TaskManagement.Controller;

import com.TaskManagementSystem.TaskManagement.Repository.CartRepository;
import com.TaskManagementSystem.TaskManagement.Service.CartService;
import com.TaskManagementSystem.TaskManagement.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final CartRepository cartRepository;
    @Autowired
    public CartController(CartService cartService, CartRepository cartRepository) {
        this.cartService =cartService ;
        this.cartRepository = cartRepository;
    }
    @GetMapping("/cart")
    public List<Cart> getCartItems(){
        return cartService.getCartItems(cartRepository);
    }
    @PostMapping("/add")
    public void addToCart(@RequestBody Cart cart){
        cartService.addToCart(cart,cartRepository);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCart(@PathVariable("id")Integer id){
        CartService.deleteCart(id,cartRepository);
    }
    @GetMapping(path = "/delete/{email}")
    public List<Cart> findUserByEmail(@PathVariable String email ){

        return CartService.findUserByEmail(email,cartRepository);
    }
    @PutMapping("/{productName}")
    void cartProduct(@RequestBody Cart cart, @PathVariable String productName) {
        int productquantity = 5;

    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        CartService.deleteAll(cartRepository);
    }

}
