package intbit.heapsandmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 *
 *  If K > N, return empty array.
 *  A[i] is a signed integer
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 */
public class DistinctsNumberInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (B <= 0 && B > A.size())
            return result;
        for (int i = 0; i < B; i++) {
            map.merge(A.get(i), 1, Integer::sum);
        }
        result.add(map.size());
        for (int k = B; k < A.size(); k++) {
            int removedKey = A.get(k-B);
            int count = map.get(removedKey);
            if (count == 1) {
                map.remove(removedKey);
            } else {
                map.put(removedKey, count -1);
            }
            map.merge(A.get(k), 1, Integer::sum);
            result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        DistinctsNumberInWindow obj = new DistinctsNumberInWindow();
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 1, 3, 4, 3));
        System.out.println(obj.dNums(A,3));
    }
}
