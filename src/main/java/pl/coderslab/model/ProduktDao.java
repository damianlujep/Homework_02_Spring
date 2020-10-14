package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

public class ProduktDao {
    private List<Product> productsList = new ArrayList<>();

    public List<Product> getList(){
        return this.productsList;
    }


}
