package intbit.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Jump Game Array
 * Asked in:
 * Amazon
 * Ebay
 * Given an array of non-negative integers, A, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input will be an integer array A.
 * Output Format:
 * <p>
 * Return an integer, representing the answer as described in the problem statement.
 * => 0 : If you cannot reach the last index.
 * => 1 : If you can reach the last index.
 * Constraints:
 * 1 <= len(A) <= 1e6
 * 0 <= A[i] <= 30
 * <p>
 * Examples:
 * <p>
 * Input 1:
 * A = [2,3,1,1,4]
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * Index 0 -> Index 2 -> Index 3 -> Index 4 -> Index 5
 * <p>
 * Input 2:
 * A = [3,2,1,0,4]
 * <p>
 * Output 2:
 * 0
 * <p>
 * Explanation 2:
 * There is no possible path to reach the last index.
 */
public class JumpGameArray {
    public int canJump(ArrayList<Integer> A) {
        return canJump(A, 0, new HashMap<Integer, Boolean>()) ? 1 : 0;
    }

    public boolean canJump(ArrayList<Integer> A, int index, HashMap<Integer, Boolean> map) {
        if (index == A.size() - 1)
            return true;
        for (int i = 1; i <= A.get(index); i++) {
            if (!map.containsKey(index + i))
                map.put(index + i, canJump(A, index + i, map));
            if (map.get(index+i))
                return true;
        }
        return false;
    }

    /**
     * dp solution
     * @param A
     * @return
     */
    public int canJump_(ArrayList<Integer> A) {
        boolean[] table = new boolean[A.size()];
        table[table.length - 1] = true;
        for (int j = table.length - 2; j >= 0; j--) {
            if (j + A.get(j) >= A.size() - 1)
                table[j] = true;
            for (int i = A.get(j); i >= 0 && !table[j]; i--) {
                table[j] = table[j + i];
            }
        }
        return table[0]? 1 : 0;
    }

    /**
     * Best solution
     * @param a
     * @return
     */
    public int canJump_2(ArrayList<Integer> a) {
        int currJump= 0;
        for (int i=0; i<a.size(); i++){
            if (currJump<0) return 0;
            currJump= Math.max(a.get(i),currJump);
            currJump--;
        }
        return 1;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 1, 1, 4);
        ArrayList<Integer> arr1 = new ArrayList<>(list);
        JumpGameArray obj = new JumpGameArray();
        System.out.println(obj.canJump(arr1));
        List<Integer> list2 = List.of(3, 2, 0, 1, 4);
        ArrayList<Integer> arr2 = new ArrayList<>(list2);
        System.out.println(obj.canJump(arr2));
        List<Integer> list3 = List
                .of(16, 0, 0, 0, 12, 1, 13, 1, 30, 0, 14, 0, 0, 3, 0, 0, 2, 0, 0, 0, 7, 0, 0, 0, 0,
                        16, 0, 14, 0, 22, 0, 0, 0, 5, 0, 0, 0, 0, 7, 0, 26, 0, 0, 13, 22, 0, 0, 0,
                        0, 22, 0, 0, 0, 16, 0, 0, 29, 0, 0, 0, 3, 0, 0, 0, 28, 0, 0, 0, 29, 0, 0, 0,
                        0, 0, 0, 3, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 3, 0, 0, 0, 19, 0, 0, 15, 0, 0,
                        30, 0, 0, 0, 0, 0, 0, 12, 0, 19, 6, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 12,
                        0, 24, 16, 21, 0, 8, 0, 14, 6, 0, 0, 5, 23, 0, 22, 0, 15, 15, 0, 26, 0, 14,
                        0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 13, 0, 24, 0, 0, 16, 24, 0, 9, 0,
                        0, 0, 0, 0, 21, 0, 0, 25, 0, 0, 0, 0, 0, 27, 0, 0, 0, 0, 0, 0, 0, 24, 0, 0,
                        0, 0, 0, 30, 10, 0, 18, 30, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 29, 0, 0, 0,
                        8, 7, 29, 16, 30, 0, 0, 3, 0, 0, 0, 17, 0, 0, 22, 0, 0, 0, 0, 0, 18, 0, 0,
                        11, 11, 0, 0, 0, 0, 11, 19, 2, 0, 0, 0, 2, 0, 16, 11, 21, 0, 10, 0, 29, 0,
                        0, 0, 0, 0, 1, 15, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 29, 0, 9, 0, 6, 0,
                        0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0,
                        0, 0, 0, 11, 0, 0, 21, 0, 0, 0, 0, 4, 0, 0, 0, 0, 14, 21, 0, 0, 0, 0, 0, 0,
                        0, 5, 0, 0, 0, 0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 14, 0, 0, 0, 0, 29,
                        24, 0, 4, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 25,
                        0, 9, 0, 0, 0, 0, 24, 21, 12, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 29, 2, 0, 0,
                        0, 22, 9, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 8, 29, 19, 0, 0, 0, 14, 24, 0,
                        22, 0, 24, 0, 0, 5, 0, 0, 0, 28, 0, 0, 29, 0, 0, 27, 13, 0, 18, 0, 0, 0, 0,
                        11, 11, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 12, 0, 0, 12,
                        19, 23, 0, 20, 0, 8, 6, 23, 17, 14, 0, 0, 24, 3, 0, 0, 0, 6, 11, 24, 0, 0,
                        0, 0, 0, 0, 18, 0, 0, 1, 27, 0, 1, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 11, 16, 0,
                        0, 24, 25, 0, 0, 17, 0, 0, 0, 0, 21, 0, 0, 0, 0, 0, 9, 19, 0, 0, 0, 0, 0, 0,
                        6, 0, 0, 5, 0, 15, 17, 14, 1, 27, 0, 0, 24, 16, 28, 0, 18, 0, 20, 20, 0, 29,
                        0, 2, 29, 0, 0, 17, 0, 30, 0, 0, 0, 0, 0, 29, 15, 0, 0, 0, 0, 0, 0, 0, 14,
                        0, 0, 16, 0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 21, 0, 6,
                        0, 0, 0, 0, 0, 0, 0, 0, 28, 11, 19, 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 15,
                        0, 0, 6, 3, 4, 0, 0, 0, 0, 22, 0, 2, 0, 0, 0, 14, 0, 0, 5, 0, 18, 27, 0, 0,
                        0, 0, 0, 28, 0, 0, 0, 9, 0, 20, 4, 28, 0, 0, 4, 0, 0, 3, 0, 3, 9, 3, 0, 6,
                        0, 0, 0, 0, 0, 0, 13, 0, 23, 0, 0, 16, 5, 0, 27, 4, 0, 28, 0, 0, 0, 0, 0, 0,
                        0, 5, 0, 24, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 4, 10, 28, 0, 0, 0, 22, 14, 8, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 21, 0, 30, 0, 0, 19, 0, 0, 0, 0, 7, 0,
                        22, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 13, 29, 18, 0, 0, 0, 0, 0, 0, 0, 0,
                        29, 30, 0, 0, 0, 28, 0, 0, 18, 26, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 5, 0, 27, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 29, 16, 13, 0, 3,
                        0, 0, 11, 12, 7, 3, 0, 2, 0, 0, 16, 0, 0, 26, 0, 15, 0, 20, 0, 0, 0, 0, 0,
                        0, 0, 4, 0, 0, 25, 3, 27, 0, 0, 0, 13, 0, 0, 0, 0, 22, 25, 0, 22, 25, 0, 17,
                        29, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 28, 8, 1, 0, 0, 0, 0, 0, 29, 15, 16,
                        0, 0, 0, 0, 0, 0, 23, 28, 0, 0, 0, 2, 0, 12, 27, 0, 22, 0, 0);
        ArrayList<Integer> arr3 = new ArrayList<>(list3);
        System.out.println(obj.canJump_(arr1));
        System.out.println(obj.canJump_(arr2));
        System.out.println(obj.canJump_(arr3));
        System.out.println(obj.canJump(arr3));
    }
}
