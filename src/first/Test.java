package first;
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

  Example:

    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X

    Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O'
 that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected
 if they are adjacent cells connected horizontally or vertically.
*/

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution130 solution = new Solution130();

        Vehicle vehicle = new Vehicle();
        System.out.println(vehicle.test());
        Vehicle car = new Car();
        // car.start();

        Car secondCar = new Car();
        if (vehicle instanceof Car) {
            System.out.println("it is");
        }
        // secondCar.start();

        Car thirdCar = new Car();

        System.out.println(thirdCar.equals(secondCar));
        System.out.println(car == secondCar);

        System.out.println(thirdCar == secondCar);

        List<Car> cars = new ArrayList<>();

        vehicle = secondCar;

        System.out.println(vehicle.getClass() == secondCar.getClass());
        System.out.println(car.getClass() == secondCar.getClass());

        cars.add(secondCar);
        Collections.sort(cars);
        System.out.println(cars);

        String s;

        Iterator<Car> carIterator = cars.iterator();

        while (carIterator.hasNext()) {
            System.out.println("test");
            carIterator.next();
        }

        Stack<String> stack = new Stack<>();

        SmallAnimal sa = new Cow();
        SmallAnimal sa1 = new Cow();

        sa = sa1;
        System.out.println(sa + " " + sa1);

    }
}

class Vehicle {
    int number = 1;

    public void start() {
        System.out.println("vehicle started " + number);
    }

    Vehicle () {
        System.out.println(number);
    }

    public int test() {
        try {

            throw new Exception();
        } catch (Exception e) {
            System.out.println("Exception caught");
            return 2;
        } finally {
            System.out.println("Finally always runs");
            return 4;
        }
    }
}

class Car extends Vehicle implements Comparable<Car> {
    Car() {
        System.out.println(number);
    }

    int number = 2;

    public void start() {
        System.out.println("car started " + number);
    }

    public void fill() {

    }

    public int compareTo(Car c) {
        return this.number - c.number;
    }
}

abstract class Animal implements SmallAnimal, SmallerAnimal {
    Animal() {
    }

    public void roar() {

    }

    public void test() {
        
    }
}

interface SmallAnimal {
    default void roar() {}

    static void test() {

    }
}

interface SmallerAnimal {
    void roar();
}

class Cow extends Animal{

}