package intbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3],
 * ]
 * */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsets(res, a, new ArrayList<Integer>(), 0, a.size());
        return res;
    }

    private void subsets(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> a, ArrayList<Integer> list, int start, int n) {
        res.add((ArrayList<Integer>) list.clone());
        if (n == start)
            return;
        for (int i = start; i < n; i++) {
            int size = list.size();
            list.add(a.get(i));
            subsets(res, a, list, i + 1, n);
            list.remove(size);
        }
    }

    public static void main(String[] args) {
        Subset obj = new Subset();
        List<Integer> list = List.of(1, 2, 3);
        ArrayList<Integer> a = new ArrayList<Integer>(list);
        System.out.println(obj.subsets(a));
    }
}
