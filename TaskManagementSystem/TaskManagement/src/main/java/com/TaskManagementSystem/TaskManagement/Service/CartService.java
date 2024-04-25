package com.TaskManagementSystem.TaskManagement.Service;

import com.TaskManagementSystem.TaskManagement.Repository.CartRepository;
import com.TaskManagementSystem.TaskManagement.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    private final CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository= cartRepository;
    }
    // get  all cart item
    public List<Cart> getCartItems(CartRepository cartRepository){
        return cartRepository.findAll();
    }

    // find cart by useer email

    public static List<Cart> findUserByEmail(String email , CartRepository cartRepository){
        return cartRepository.findUserByEmal(email);

    }

    // delete all cart
    public static void deleteAll(CartRepository cartRepository){
        cartRepository.deleteAll();
    }

    // add to cart
    public void addToCart(Cart cart , CartRepository cartRepository){
        cartRepository.save(cart);
    }

    // delete cart by id
    private void deleteCartById(Cart cart){
        int id = cart.getOrder_id();
        cartRepository.deleteById(id);
    }

    // delete cart
    public static void deleteCart(Integer id , CartRepository cartRepository){
        boolean b = cartRepository.existsById(id);
        if(!b){
            throw new IllegalStateException("cart not found");
        }
        cartRepository.deleteById(id);
    }

}
