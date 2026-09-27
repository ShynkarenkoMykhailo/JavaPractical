import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    @Override
    public String toString() {
        return "ID: " + id +
                ", Назва: " + name +
                ", Ціна: " + price + " грн" +
                ", Опис: " + description +
                ", Категорія: " + category.getName();
    }
}