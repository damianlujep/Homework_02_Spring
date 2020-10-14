package pl.coderslab.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void deleteFromCart(CartItem cartItem){
        cartItems.remove(cartItem);
    }

    public void increaseQuantityByOne(CartItem cartItem){
        int i = cartItems.indexOf(cartItem);
        this.cartItems.get(i).setQuantity(this.cartItems.get(i).getQuantity() + 1);
    }

    public CartItem readFromList(CartItem cartItem){
        int i = cartItems.indexOf(cartItem);
        return cartItems.get(i);
    }
}
