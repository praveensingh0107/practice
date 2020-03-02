package intbit.hashing;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * Example :
 *
 * Input :
 *
 * A : [1 5 3]
 * k : 2
 * Output :
 *
 * 1
 * as 3 - 1 = 2
 *
 * Return 0 / 1 for this problem.
 */
public class DiffKProblem {

    public int diffPossible(final List<Integer> A, int B) {
        //Collections.sort(A);
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            if (set.contains((long)(A.get(i) - B)) || set.contains((long)(A.get(i) + B)))
                return 1;
            else {
                set.add((long)A.get(i));
            }
        }
        return 0;
    }

    public int diffPossible1(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A.get(i)+B) || map.containsKey(A.get(i)-B)) {
                return 1;
            }
            map.put(A.get(i), i);
        }
        return 0;
    }

    /**
     * A : [ 34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29 ]
     * B : 97
     *
     */
    public static void main(String[] args) {
        DiffKProblem obj = new DiffKProblem();
        List<Integer> A = List.of(1, 5, 3);
        System.out.println(obj.diffPossible(A, 2));
        List<Integer> A1 = List.of(66, 37, 46, 56, 49, 65, 62, 21, 7, 70, 13, 71, 93, 26, 18, 84, 96, 65, 92, 69, 97, 47, 6, 18, 17, 47, 28, 71, 70, 24, 46, 58, 71, 21, 30, 44, 78, 31, 45, 65, 16, 3, 22, 54, 51, 68, 19, 86, 44, 99, 53, 24, 40, 92, 38, 81, 4, 96, 1, 13, 45, 76, 77, 8, 88, 50, 89, 38, 60, 61, 49, 25, 10, 80, 49, 63, 95, 74, 29, 27, 52, 27, 40, 66, 38, 22, 85, 22, 91, 98, 19, 20, 78, 77, 48, 63, 27);
        System.out.println(obj.diffPossible(A1, 31));
        System.out.println(obj.diffPossible1(A1, 31));

        List<Integer> A2 = List.of(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29 );
        System.out.println(obj.diffPossible(A2, 97));
        System.out.println(obj.diffPossible1(A2, 97));
    }
}
