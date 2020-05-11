package intbit.greedy;

import java.util.Arrays;
import java.util.List;

/**
 * Majority Element
 * Asked in:
 * Microsoft
 * Yahoo
 * Google
 * Amazon
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example :
 * <p>
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int element = A.get(0);
        int count = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == element)
                count++;
            else
                count--;
            if (count == 0) {
                element = A.get(i);
                count = 1;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        List<Integer> list = Arrays.asList(2, 1, 2, 3);
        System.out.println(obj.majorityElement(list));
    }
}
