
abstract class Car {
    abstract void start();
    void fuelType() {
        System.out.println("Petrol or Diesel");
    }
}

class Sedan extends Car {
    void start() {
        System.out.println("Sedan starts with a key");
    }
}

class SUV extends Car {
    void start() {
        System.out.println("SUV starts with a button");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Car c1 = new Sedan();
        Car c2 = new SUV();

        c1.start();
        c1.fuelType();

        c2.start();
        c2.fuelType();
    }
}
