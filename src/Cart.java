import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Товар додано до кошика.");
    }

    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println("Товар видалено з кошика.");
    }

    public double getTotalPrice() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public void clear() {
        products.clear();
    }

    @Override
    public String toString() {

        if (products.isEmpty()) {
            return "Кошик порожній.";
        }

        String result = "Кошик:\n";

        for (Product product : products) {
            result += product + "\n";
        }

        result += "Загальна вартість: " + getTotalPrice() + " грн";

        return result;
    }
}
