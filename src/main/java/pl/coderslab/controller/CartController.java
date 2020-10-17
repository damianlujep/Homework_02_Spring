package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;
import pl.coderslab.model.ProductDao;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CartController {
    final Cart cart;
    final ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @PostMapping("/addtocart")
    public String addToCart(@RequestParam String productSelected, @RequestParam int quantity) {

        Product newProduct = productDao.findProductByName(productSelected);

        List<CartItem> cartItems = this.cart.getCartItems();

        boolean exists = false;

        for (CartItem c : cartItems) {
            if (c.getProduct().equals(newProduct)) {
                c.setQuantity(c.getQuantity() + quantity);
                exists = true;
                break;
            }
        }

        if (!exists) {
            this.cart.addToCart(new CartItem(quantity, newProduct));
        }

        return "redirect: /showCart";

    }

    @RequestMapping("/addproductform")
    public String addProductForm(Model model) {
        List<Product> list = productDao.getList();
        model.addAttribute("productsList", list);

        return "add-product-form";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart() {
        String html = "<ul>\r\n<li>";

        String list = this.cart.getCartItems().stream()
                .map(CartItem::toString)
                .collect(Collectors.joining("</li>\r\n<li>"));

        return html + list + "</li></ul>";
    }

    @GetMapping("/showCart")
    public String showCart(Model model) {
        List<CartItem> cartItems = this.cart.getCartItems();
        model.addAttribute("cartItems", cartItems);

        return "show-cart";
    }

    @GetMapping("/increasebyone/{productName}")
    public String increaseQuantityByOne(@PathVariable String productName) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem c : cartItems) {
            if (c.getProduct().getName().equals(productName)) {
                cart.increaseQuantityByOne(c);
            }
        }
        return "redirect: /showCart";
    }

    @GetMapping("/decreasebyone/{productName}")
    public String decreaseQuantityByOne(@PathVariable String productName) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem c : cartItems) {
            if (c.getProduct().getName().equals(productName)) {
                cart.decreaseQuantityByOne(c);
            }
        }
        return "redirect: /showCart";
    }

}
