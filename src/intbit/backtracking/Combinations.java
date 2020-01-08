package intbit.backtracking;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 * <p>
 * Make sure the combinations are sorted.
 * <p>
 * To elaborate,
 * <p>
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * Example :
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [1,2],
 * [1,3],
 * [1,4],
 * [2,3],
 * [2,4],
 * [3,4],
 * ]
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n < k || n < 0 || k < 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<Integer>(), 0, n, k);
        return res;
    }

    private void combine(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int index,
            int n, int k) {
        if (list.size() == k) {
            res.add((ArrayList<Integer>) list.clone());
        } else {
            for (int i = index; i < n; i++) {
                list.add(i + 1);
                combine(res, list, i + 1, n, k);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(obj.combine(4, 2));
        System.out.println(obj.combine(4, 3));
        System.out.println(obj.combine(4, 1));
        System.out.println(obj.combine(4, 0));
    }
}
