package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class CartController {
    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addToCart() {
        Random rand = new Random();
        double roundedNumber = Math.round((rand.nextDouble() * 100.0)) / 100.0;

        this.cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), roundedNumber)));
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart(){
        String html = "<ul>\r\n<li>";

        String list = this.cart.getCartItems().stream()
                .map(CartItem::toString)
                .collect(Collectors.joining("</li>\r\n<li>"));

        return html + list + "</li></ul>";
    }

    @GetMapping("/showCart")
    public String showCart(Model model){
        List<CartItem> cartItems = this.cart.getCartItems();
        model.addAttribute("cartItems", cartItems);

        return "show-cart";
    }

    @GetMapping("/increasebyone/{productName}")
    public String increaseQuantityByOne(@PathVariable String productName, Model model){
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem c : cartItems){
            if (c.getProduct().getName().equals(productName)){
                cart.increaseQuantityByOne(c);
            }
        }
        return "redirect: /showCart";
    }

}
