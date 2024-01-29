package com.pailsail.service;

import com.pailsail.model.CartItem;
import com.pailsail.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> findCartItemById(Long id) {
        return cartItemRepository.findById(id);
    }

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long id, CartItem cartItemDetails) {
        return cartItemRepository.findById(id)
            .map(cartItem -> {
                cartItem.setProductId(cartItemDetails.getProductId());
                cartItem.setQuantity(cartItemDetails.getQuantity());
                cartItem.setSize(cartItemDetails.getSize());
                return cartItemRepository.save(cartItem);
            })
            .orElseGet(() -> {
                cartItemDetails.setId(id);
                return cartItemRepository.save(cartItemDetails);
            });
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
