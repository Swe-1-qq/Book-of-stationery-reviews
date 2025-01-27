package com.swe1qq.stationery.PresentationLayer;

import com.swe1qq.stationery.DataAccessLayer.Entity.Product;
import com.swe1qq.stationery.DataAccessLayer.Entity.Review;
import com.swe1qq.stationery.DataAccessLayer.Entity.User;
import com.swe1qq.stationery.ServiceLayer.ProductService;
import com.swe1qq.stationery.ServiceLayer.ReviewService;
import com.swe1qq.stationery.ServiceLayer.UserService;

import java.util.List;
import java.util.Scanner;

/**
 * Клас ConsoleInterface відповідає за взаємодію з користувачем через консоль.
 */
public class ConsoleInterface {
    private final UserService userService;
    private final ReviewService reviewService;
    private final ProductService productService;
    private final Scanner scanner;

    /**
     * Конструктор класу ConsoleInterface.
     *
     * @param userService    Сервіс для роботи з користувачами.
     * @param reviewService  Сервіс для роботи з відгуками.
     * @param productService Сервіс для роботи з продуктами.
     */
    public ConsoleInterface(UserService userService, ReviewService reviewService, ProductService productService) {
        this.userService = userService;
        this.reviewService = reviewService;
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Виводить головне меню програми.
     */
    public void showMenu() {
        System.out.println("Головне меню:");
        System.out.println("1. Додати користувача");
        System.out.println("2. Переглянути відгуки");
        System.out.println("3. Додати відгук");
        System.out.println("4. Переглянути товари");
        System.out.println("5. Додати послугу або товар");
        System.out.println("6. Вийти");
    }

    /**
     * Обробляє введення користувача та виконує відповідну операцію згідно з вибором.
     */
    public void handleUserInput() {
        boolean running = true;
        while (running) {
            showMenu();
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера після nextInt()

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    displayReviews();
                    break;
                case 3:
                    addReview();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    addProduct();
                    break;
                case 6:
                    System.out.println("Дякуємо за використання програми. До побачення!");
                    running = false;
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }

    /**
     * Додає нового користувача за допомогою введення з консолі.
     */
    private void addUser() {
        System.out.print("Введіть ім'я користувача: ");
        String username = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();
        userService.createUser(new User(username, password));
        System.out.println("Користувач " + username + " створений успішно.");
    }

    /**
     * Виводить список відгуків на консоль.
     */
    private void displayReviews() {
        List<Review> reviews = reviewService.getReviews();
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    /**
     * Виводить список товарів на консоль.
     */
    private void displayProducts() {
        List<Product> products = productService.getProducts();
        System.out.println("Список доступних товарів:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    /**
     * Додає новий відгук за допомогою введення з консолі.
     */
    private void addReview() {
        System.out.print("Введіть ваше ім'я: ");
        String username = scanner.nextLine();
        System.out.print("Напишіть ваш відгук: ");
        String content = scanner.nextLine();
        reviewService.createReview(new Review(username, content));
        System.out.println("Ваш відгук успішно доданий.");
    }

    /**
     * Додає новий продукт за допомогою введення з консолі.
     */
    private void addProduct() {
        System.out.print("Введіть назву продукту: ");
        String name = scanner.nextLine();
        System.out.print("Введіть опис продукту: ");
        String description = scanner.nextLine();
        productService.createProduct(new Product(name, description));
        System.out.println("Продукт " + name + " доданий успішно.");
    }
}

