import java.util.HashMap;

class Product {
    Double price;
}

class Order {
    HashMap<Product, Integer> orderMap;

    Order() {
        orderMap = new HashMap<Product, Integer>();
    }
}
// enum CoffeeSize {
// 	SMALL,
// 	MEDIUM,
// 	LARGE
// }

class Coffee extends Product {
    // CoffeeSize size;

}

// enum BurgerSize {
// 	L,
// 	XL,
// }

class Burger extends Product {
}

class Mocha extends Coffee {

    Mocha() {
        price = 10.0;
// 	}
// 	Double priceS = 10;
// 	Double priceM = 20;
// 	Double priceL = 30; 
    }
}

class Espresso extends Coffee {
    Espresso() {
        price = 20.0;
    }
    // Double priceS = 5;
    // Double priceM = 10;
    // Double priceL = 20;
}

class VegBurger extends Burger {

    VegBurger() {
        price = 100.0;
    }
    // Double priceL = 100;
    // Double priceXL = 150;
}

class ChickenBurger extends Burger {

    ChickenBurger() {
        price = 150.0;
    }
    // Double priceL = 150;
    // Double priceXL = 200;
}


public class CoffeeShop {

    public static Order generateOrder() {
        Order o = new Order();
        Coffee c1 = new Mocha();
        o.orderMap.put(c1, 2);
        return o;
    }

    public static void generateBill() {

    }

    public static void main(String[] args) {
        generateOrder();
        generateBill();
    }
}
    }