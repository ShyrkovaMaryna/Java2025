package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private final List<Product> cartItems = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public void addProductById(int id) {
        productRepository.findById(id).ifPresent(cartItems::add);
    }

    public void removeProductById(int id) {
        cartItems.removeIf(product -> product.getId() == id);
    }

    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("In the basket:");
            cartItems.forEach(System.out::println);
        }
    }
}
