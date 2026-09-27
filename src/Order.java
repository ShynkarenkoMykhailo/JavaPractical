import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    private List<Product> products;
    private double totalPrice;
    private String status;

    public Order(Cart cart) {
        this.products = new ArrayList<>(cart.getProducts());
        this.totalPrice = cart.getTotalPrice();
        this.status = "Нове";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        String result = "Замовлення:\n";

        for (Product product : products) {
            result += product + "\n";
        }

        result += "Загальна вартість: " + totalPrice + " грн\n";
        result += "Статус: " + status;

        return result;
    }
}