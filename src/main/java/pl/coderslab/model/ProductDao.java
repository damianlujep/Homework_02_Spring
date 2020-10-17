package pl.coderslab.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDao {
    final List<Product> productsList = Arrays.asList(
            new Product("Lubella Makaron", 3.79, 1L),
            new Product("Maska Ochronna", 3.79, 2L),
            new Product("Milka Czekolada", 11.19, 3L),
            new Product("Polski Cukier", 2.39, 4L),
            new Product("Power Napój", 1.29, 5L),
            new Product("Rzecznik Uniwersalny", 3.79, 6L),
            new Product("Pomidory krojone", 3.79, 7L),
            new Product("Chusteczki", 2.99, 8L),
            new Product("Ogórki kwaszone", 5.19, 9L),
            new Product("Classic Mleko", 2.35, 10L),
            new Product("Czosnek", 1.99, 11L),
            new Product("Ser Camembert", 3.79, 12L),
            new Product("Oliwki czarne", 10.79, 13L),
            new Product("Papier toaletowy", 8.79, 14L),
            new Product("Szpinak", 2.49, 15L));

    public List<Product> getList() {
        return this.productsList;
    }

    public Product findProductByName(String productName){
        Product product = new Product();

        for (Product p : productsList){
            if (p.getName().equals(productName)){
                product = p;
            }
        }

        return product;
    }


}
