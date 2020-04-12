package intbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Min Jumps Array
 * Asked in:
 * Amazon
 * Ebay
 * Google
 * Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Return the minimum number of jumps required to reach the last index.
 * <p>
 * If it is not possible to reach the last index, return -1.
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains an integer array, A.
 * Output Format:
 * <p>
 * Return an integer, representing the answer as described in the problem statement.
 * Constraints:
 * <p>
 * 1 <= N <= 1e6
 * 0 <= A[i] <= 50000
 * Examples:
 * <p>
 * Input 1:
 * A = [2, 1, 1]
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * The shortest way to reach index 2 is
 * Index 0 -> Index 2
 * that requires only 1 jump.
 * <p>
 * Input 2:
 * A = [2,3,1,1,4]
 * <p>
 * Output 2:
 * 2
 * <p>
 * Explanation 2:
 * The shortest way to reach index 4 is
 * Index 0 -> Index 1 -> Index 4
 * that requires 2 jumps.
 */
public class MinJumps {

    public int jump(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(A.size() - 1, 0);
        int minJumps = jump(A, 0, map);
        return minJumps == Integer.MAX_VALUE ? -1 : minJumps;
    }

    private int jump(ArrayList<Integer> a, int index, HashMap<Integer, Integer> map) {
        if (map.containsKey(index))
            return map.get(index);
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= a.get(index) && i + index < a.size(); i++) {
            int val = map.containsKey(index + i) ? map.get(index + i) : jump(a, index + i, map);
            minJumps = Math.min(minJumps, val);
        }
        minJumps = minJumps != Integer.MAX_VALUE ? minJumps + 1 : minJumps;
        map.put(index, minJumps);
        return minJumps;
    }

    private int _jump(ArrayList<Integer> A) {
        int[] table = new int[A.size()];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[A.size() - 1] = 0;
        for (int i = A.size() - 2; i >= 0; i--) {
            int minJumps = Integer.MAX_VALUE;
            for (int j = 1; j <= A.get(i) && i + j < A.size(); j++) {
                minJumps = Math.min(minJumps, table[i + j]);
            }
            table[i] = minJumps != Integer.MAX_VALUE ? minJumps + 1 : minJumps;
        }
        return table[0] != Integer.MAX_VALUE ? table[0] : -1;
    }

    private int _jump1(ArrayList<Integer> A) {
        if (A.get(0) == 0 && A.size() > 1)
            return -1;
        int[] table = new int[A.size()];
        table[0] = 0;
        for (int i = 1; i < A.size(); i++) {
            table[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + A.get(j) && table[j] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[j] + 1);
                    break;
                }
            }
        }
        return table[A.size() - 1] != Integer.MAX_VALUE ? table[A.size() - 1] : -1;
    }

    public int jump2(ArrayList<Integer> A) {
        if (A.get(0) == 0 && A.size() > 1)
            return -1;
        else if (A.size() == 0) return 0;
        int lastReach = A.get(0);
        int maxReach = A.get(0);
        int jumps = 1;
        for (int i = 1; i < A.size(); i++) {
            if (maxReach < i)
                return -1;
            if (lastReach < i) {
                jumps++;
                lastReach = maxReach;
            }
            maxReach = Math.max(maxReach, i + A.get(i));
        }
        return jumps;
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(2, 1, 1);
        ArrayList<Integer> a1 = new ArrayList<>(l1);
        MinJumps obj = new MinJumps();
        //System.out.println(obj.jump(a1));
        List<Integer> l2 = List.of(2, 3, 1, 1, 4);
        ArrayList<Integer> a2 = new ArrayList<>(l2);
        //System.out.println(obj.jump(a2));
        List<Integer> l3 = List.of(3, 2, 1, 0, 1);
        ArrayList<Integer> a3 = new ArrayList<>(l3);
        //System.out.println(obj.jump(a3));
        System.out.println(obj._jump(a1));
        System.out.println(obj._jump(a2));
        System.out.println(obj._jump(a3));
        //System.out.println(obj._jump1(a1));
        //System.out.println(obj._jump1(a2));
        //System.out.println(obj._jump1(a3));
        /*System.out.println(obj.jump2(a1));
        System.out.println(obj.jump2(a2));
        System.out.println(obj.jump2(a3));*/
        List<Integer> l4 = List
                .of(33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41,
                        18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2,
                        27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9,
                        36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23,
                        22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41,
                        2, 48, 28);
        ArrayList<Integer> a4 = new ArrayList<>(l4);
        System.out.println(obj._jump(a4));
        System.out.println(obj.jump2(a4));
    }
}
