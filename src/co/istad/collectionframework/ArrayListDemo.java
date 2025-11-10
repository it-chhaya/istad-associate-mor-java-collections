package co.istad.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        // Generic Type must be any class
        // Generic type cannot be primitive type
        List<String> players = new ArrayList<>();
        List<Double> ratings = new ArrayList<>();

        players.add("Messi");
        players.add("Neymar");

        ratings.add(9.9);
        ratings.add(9.0);

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i) + " has rating: " + ratings.get(i));
        }


//        List<Integer> oldNumbers = List.of(8888,9999);
//
//        List<Integer> numbers = new ArrayList<>();
//
//        // Add new element into array list
//        numbers.add(100);
//        numbers.add(200);
//        numbers.add(300);
//
//        numbers.addAll(oldNumbers);
//
//        // Update element of array list
//        numbers.set(0, 1000);
//
//        numbers.add(1, 90);
//
//        numbers.addFirst(80);
//        numbers.addLast(99);
//
//        numbers.remove(Integer.valueOf(300));
//        numbers.removeFirst();
//
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println("normal for: " + numbers.get(i));
//        }
//
//        // Enhanced for or for-each
//        for (Integer num : numbers) {
//            System.out.println("enhance for: " + num);
//        }

    }
}
