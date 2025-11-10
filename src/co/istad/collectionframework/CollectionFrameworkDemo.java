package co.istad.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class CollectionFrameworkDemo {
    public static void main(String[] args) {

        // How to create array list
        // 1. use polymorphism
        List<Integer> numbers = new ArrayList<>();

        // 2. normal
        ArrayList<Integer> normalNumbers = new ArrayList<>();

        System.out.println(numbers);
        System.out.println(normalNumbers);


//        // Normal or static array
//        int[] numbers = new int[5];
//
//        // Dynamic array
//        // Default size = 10 => 15 => 20
//        List<Integer> numbersCollection = new ArrayList<>();
    }
}
