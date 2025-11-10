package co.istad.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRawDemo {
    public static void main(String[] args) {
        List data = new ArrayList();
        data.add(1);
        data.add("Chan Dara");
        data.add(false);
        data.add(45.4);

        for (Object d : data) {
            System.out.println(d);
        }
    }
}
