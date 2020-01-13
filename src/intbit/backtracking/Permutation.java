package intbit.backtracking;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * Example:
 *
 * [1,2,3] will have the following permutations:
 *
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 *  NOTE
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * */
public class Permutation {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        boolean[] marked = new boolean[a.size()];
        permute(results, new ArrayList<Integer>(), a, marked, 0);
        return results;
    }

    private void permute(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result,
            ArrayList<Integer> a, boolean[] marked, int index) {
        if (index == a.size()) {
            results.add((ArrayList<Integer>) result.clone());
        } else {
            IntStream.range(0, a.size()).forEach(i -> {
                if (!marked[i]) {
                    marked[i] = true;
                    result.add(a.get(i));
                    permute(results, result, a, marked, index + 1);
                    result.remove(result.size() - 1);
                    marked[i] = false;
                }
            });
        }
    }

    public static void main(String[] args) {
        Permutation obj = new Permutation();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(2); a.add(3);
        System.out.println(obj.permute(a));
    }
}
