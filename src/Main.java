import java.util.ArrayList;
import java.util.List;

class Goods {
    private final String name;
    private final double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Apple extends Goods {
    public Apple() {
        super("apple", 8);
    }
}

class Strawberry extends Goods {
    public Strawberry() {
        super("strawberry", 13);
    }
}

class Mango extends Goods {
    public Mango() {
        super("mango", 20);
    }
}

class ShoppingCart {
    private final List<Goods> goodsList;

    public ShoppingCart() {
        goodsList = new ArrayList<Goods>();
    }

    public void addToCart(Goods goods, int weight) {
        for (int i = 0; i < weight; i++) {
            goodsList.add(goods);
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Goods fruit : goodsList) {
            totalPrice += fruit.getPrice();
        }
        return totalPrice;
    }

    public double calculateTotalPriceWithStrawberryDiscount() {
        double totalPrice = 0;
        for (Goods fruit : goodsList) {
            if (fruit instanceof Strawberry) {
                totalPrice += fruit.getPrice() * 0.8;
            } else {
                totalPrice += fruit.getPrice();
            }
        }
        return totalPrice;
    }

    public double calculateTotalPriceWithTotalDiscount() {
        double totalPrice = calculateTotalPriceWithStrawberryDiscount();
        if (totalPrice >= 100) {
            totalPrice -= 10;
        }
        return totalPrice;
    }
}
public class Main {
    public static void main(String[] args) {

        ShoppingCart customerA = new ShoppingCart();
        customerA.addToCart(new Apple(), 5);
        customerA.addToCart(new Strawberry(), 5);
        System.out.println("Customer A need to paid：" + customerA.calculateTotalPrice());

        ShoppingCart customerB = new ShoppingCart();
        customerB.addToCart(new Apple(), 5);
        customerB.addToCart(new Strawberry(), 5);
        customerB.addToCart(new Mango(), 5);
        System.out.println("Customer B need to paid：" + customerB.calculateTotalPrice());

        ShoppingCart customerC = new ShoppingCart();
        customerC.addToCart(new Apple(), 5);
        customerC.addToCart(new Strawberry(), 5);
        customerC.addToCart(new Mango(), 5);
        System.out.println("Customer C need to paid：" + customerC.calculateTotalPriceWithStrawberryDiscount());

        ShoppingCart customerD = new ShoppingCart();
        customerD.addToCart(new Apple(), 5);
        customerD.addToCart(new Strawberry(), 5);
        customerD.addToCart(new Mango(), 5);
        System.out.println("Customer D need to paid：" + customerD.calculateTotalPriceWithTotalDiscount());
    }
}