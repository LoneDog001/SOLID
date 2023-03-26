import java.util.*;

public class Main extends ItemCart implements GetProducts, Payment { // Interface segregation principle
    static ArrayList<Products> basket = new ArrayList<>();

    public static void main(String[] args) {
        Logger logger = new ConsoleLogger(); // Dependency inversion principle
        ItemCart itemCart = new Main();
        GetProducts getProducts = new Main();
        Payment payment = new Main();
        Scanner scr = new Scanner(System.in);
        ArrayList<Products> phone = new ArrayList<>();
        phone.add(new Products("Samsung", "А50", "Samsung", 85666.3, 4.5));
        phone.add(new Products("Iphone", "Iphone 12", "Apple", 45600.99, 4.6));
        ArrayList<Products> tv = new ArrayList<>();
        tv.add(new Products("Xiaomi", "Xiaomi TV A2 50", "Xiaomi", 32299.12, 4.4));
        tv.add(new Products("LG", "SIGNATURE OLED R", "LG", 123544.35, 4.8));
        System.out.println("Выберите каталог");
        System.out.println("1. Телефоны " + " \n2. TV");
        int input = scr.nextInt();
        switch (input) {
            case 1:
                itemCart.print(phone);
                break;
            case 2:
                itemCart.print(tv);
                break;
        }
        System.out.println("Выберите действие");
        System.out.println("""
                1. Добавить в корзину\s
                2. Отсортировать по рейтингу\s
                3. Отсортировать по цене\s""");
        int input2 = scr.nextInt();
        switch (input2) {
            case 1:
                System.out.println("Выберете товар из списка");
                if (input == 1) {
                    itemCart.print(phone);
                    int input3 = scr.nextInt() - 1;
                    if (input3 == 0) {
                        basket.add(phone.get(0));
                        System.out.println("Вы поместили в корзину" + basket);
                    } else if (input3 == 1) {
                        basket.add(phone.get(1));
                        System.out.println("Вы поместили в корзину" + basket);
                    }
                } else if (input == 2) {
                    itemCart.print(tv);
                    int input3 = scr.nextInt() - 1;
                    if (input3 == 0) {
                        basket.add(tv.get(0));
                        itemCart(basket);
                    } else if (input3 == 1) {
                        basket.add(tv.get(1));
                        itemCart(basket);
                    }
                }
                break;
            case 2:
                if (input == 1) {
                    Collections.sort(phone, compareByRating);
                    System.out.println(phone);
                } else {
                    Collections.sort(tv, compareByRating);
                    System.out.println(tv);
                }
                break;
            case 3:
                if (input == 1) {
                    Collections.sort(phone, compareByPrice);
                    System.out.println(phone);
                } else {
                    Collections.sort(tv, compareByRating);
                    System.out.println(tv);
                }
                break;
        }
        payment.payment();
        logger.execute();
        getProducts.getProducts();

    }

    static Comparator<Products> compareByRating = (o1, o2) -> (int) (o1.getRating() - o2.getRating());

    static Comparator<Products> compareByPrice = (o1, o2) -> (int) (o1.getPrice() - o2.getPrice());

    @Override
    void print(ArrayList<Products> list) {  //DRY // Liskov substitution principle
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    @Override
    public void getProducts() {
        System.out.println("Вы получили продукт на кассе");
    }

    @Override
    public void payment() {
        System.out.println("Вы оплатили заказ");
    }
}
