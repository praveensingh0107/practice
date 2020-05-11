package intbit.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Assign Mice to Holes
 * Asked in:
 * Amazon
 * There are N Mice and N holes are placed in a straight line.
 * Each hole can accomodate only 1 mouse.
 * A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consumes 1 minute.
 * Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
 * <p>
 * Example:
 * <p>
 * positions of mice are:
 * 4 -4 2
 * positions of holes are:
 * 4 0 5
 * <p>
 * Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes
 * Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes
 * Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes
 * After 4 minutes all of the mice are in the holes.
 * <p>
 * Since, there is no combination possible where the last mouse's time is less than 4,
 * answer = 4.
 * Input:
 * <p>
 * A :  list of positions of mice
 * B :  list of positions of holes
 * Output:
 * <p>
 * single integer value
 */
public class AssignMiceToHoles {

    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null || A.size() != B.size())
            return -1;
        int max = Integer.MIN_VALUE;
        Collections.sort(A);
        Collections.sort(B);
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(Math.abs(A.get(i) - B.get(i)), max);
        }
        return max;
    }

    public static void main(String[] args) {
        AssignMiceToHoles obj = new AssignMiceToHoles();
        ArrayList<Integer> A = new ArrayList<Integer>(List.of(4, -4, 0));
        ArrayList<Integer> B = new ArrayList<Integer>(List.of(4, 0, 5));
        System.out.println(obj.mice(A, B));
    }
}
