package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HelloWorld {

    public static ArrayList<Integer> plusOne(List<Integer> a) {
        int size = a.size();
        Collections.reverse(a);
        LinkedList<Integer> result = new LinkedList<>();
        int x = 0;
        int c = 1;
        for (int i = 0; i < size; i++) {
            x = a.get(i) + c;
            if (x >= 10) {
                result.add(x % 10);
                c = 1;
            } else {
                result.add(x);
                c = 0;
            }
        }
        if (c == 1) {
            result.add(1);
        }
        while (!result.isEmpty() && result.peekLast() == 0) {
            result.pollLast();
        }
        ArrayList<Integer> res = new ArrayList<>(result);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(8);
        list.add(9);
        list.add(9);
        System.out.println(plusOne(list));
    }
}
