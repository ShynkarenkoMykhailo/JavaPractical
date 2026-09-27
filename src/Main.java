import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Категорії
        Category electronics =
                new Category(1, "Електроніка");

        Category smartphones =
                new Category(2, "Смартфони");

        Category accessories =
                new Category(3, "Аксесуари");

        // Товари
        Product product1 = new Product(
                1,
                "Ноутбук",
                19999.99,
                "Ноутбук для роботи та навчання",
                electronics
        );

        Product product2 = new Product(
                2,
                "Смартфон",
                12999.50,
                "Смартфон з великим екраном",
                smartphones
        );

        Product product3 = new Product(
                3,
                "Навушники",
                2499.00,
                "Бездротові навушники",
                accessories
        );

        // Список товарів
        List<Product> products = new ArrayList<>();

        products.add(product1);
        products.add(product2);
        products.add(product3);

        // Кошик
        Cart cart = new Cart();

        // Історія замовлень
        List<Order> orderHistory = new ArrayList<>();

        while (true) {

            System.out.println("\n===== ІНТЕРНЕТ-МАГАЗИН =====");
            System.out.println("1 - Переглянути товари");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Видалити товар з кошика");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Історія замовлень");
            System.out.println("7 - Пошук товару");
            System.out.println("0 - Вийти");

            System.out.print("Ваш вибір: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n--- Список товарів ---");

                    for (Product product : products) {
                        System.out.println(product);
                    }

                    break;

                case 2:

                    System.out.print("Введіть ID товару: ");

                    int addId = scanner.nextInt();

                    boolean foundAdd = false;

                    for (Product product : products) {

                        if (product.getId() == addId) {

                            cart.addProduct(product);

                            foundAdd = true;

                            break;
                        }
                    }

                    if (!foundAdd) {
                        System.out.println("Товар не знайдено.");
                    }

                    break;

                case 3:

                    System.out.println("\n" + cart);

                    break;

                case 4:

                    if (cart.getProducts().isEmpty()) {

                        System.out.println("Кошик порожній.");

                        break;
                    }

                    System.out.println("\n--- Товари в кошику ---");

                    for (Product product : cart.getProducts()) {
                        System.out.println(product);
                    }

                    System.out.print(
                            "Введіть ID товару для видалення: "
                    );

                    int removeId = scanner.nextInt();

                    Product productToRemove = null;

                    for (Product product : cart.getProducts()) {

                        if (product.getId() == removeId) {

                            productToRemove = product;

                            break;
                        }
                    }

                    if (productToRemove != null) {

                        cart.removeProduct(productToRemove);

                    } else {

                        System.out.println("Товар не знайдено.");
                    }

                    break;

                case 5:

                    if (cart.getProducts().isEmpty()) {

                        System.out.println(
                                "Кошик порожній. Додайте товар."
                        );

                    } else {

                        Order order = new Order(cart);

                        orderHistory.add(order);

                        System.out.println(
                                "\nЗамовлення оформлено!"
                        );

                        System.out.println(order);

                        cart.clear();
                    }

                    break;

                case 6:

                    System.out.println("\n--- ІСТОРІЯ ЗАМОВЛЕНЬ ---");

                    if (orderHistory.isEmpty()) {

                        System.out.println(
                                "Історія замовлень порожня."
                        );

                    } else {

                        for (int i = 0; i < orderHistory.size(); i++) {

                            System.out.println(
                                    "\nЗамовлення №" + (i + 1)
                            );

                            System.out.println(
                                    orderHistory.get(i)
                            );
                        }
                    }

                    break;

                case 7:

                    System.out.println("\n--- ПОШУК ТОВАРУ ---");
                    System.out.println("1 - Пошук за назвою");
                    System.out.println("2 - Пошук за категорією");

                    System.out.print("Ваш вибір: ");

                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (searchChoice == 1) {

                        System.out.print(
                                "Введіть назву товару: "
                        );

                        String searchName =
                                scanner.nextLine().toLowerCase();

                        boolean foundName = false;

                        for (Product product : products) {

                            if (product.getName()
                                    .toLowerCase()
                                    .contains(searchName)) {

                                System.out.println(product);

                                foundName = true;
                            }
                        }

                        if (!foundName) {

                            System.out.println(
                                    "Товар не знайдено."
                            );
                        }

                    } else if (searchChoice == 2) {

                        System.out.print(
                                "Введіть назву категорії: "
                        );

                        String searchCategory =
                                scanner.nextLine().toLowerCase();

                        boolean foundCategory = false;

                        for (Product product : products) {

                            if (product.getCategory()
                                    .getName()
                                    .toLowerCase()
                                    .contains(searchCategory)) {

                                System.out.println(product);

                                foundCategory = true;
                            }
                        }

                        if (!foundCategory) {

                            System.out.println(
                                    "Товари цієї категорії не знайдено."
                            );
                        }

                    } else {

                        System.out.println(
                                "Невірний вибір."
                        );
                    }

                    break;

                case 0:

                    System.out.println(
                            "Дякуємо за використання магазину!"
                    );

                    scanner.close();

                    return;

                default:

                    System.out.println(
                            "Невірний вибір."
                    );
            }
        }
    }
}