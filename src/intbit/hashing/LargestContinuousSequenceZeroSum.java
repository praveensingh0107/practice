package intbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 *
 * Example:
 *
 *
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 *
 *  NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(List<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int startIndex = 0, length = 0;
        int sum = 0;
        map.put(0, -1); // initial sum = 0 and startIndex = map.get(0) +1
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > length) {
                    startIndex = map.get(sum) + 1;
                    length = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }

        for (int i = 0; i< length; i++) {
            result.add(A.get(startIndex + i));
        }
        return result;
    }

    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum obj = new LargestContinuousSequenceZeroSum();
        List<Integer> integers = List.of(1, 2, -2, 4, -4);
        System.out.println(obj.lszero(integers));
    }
}
