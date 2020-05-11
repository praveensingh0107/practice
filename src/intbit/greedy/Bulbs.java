package intbit.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Bulbs
 * N light bulbs are connected by a wire.
 * <p>
 * Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
 * <p>
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * <p>
 * You can press the same switch multiple times.
 * <p>
 * Note : 0 represents the bulb is off and 1 represents the bulb is on.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains an integer array A, of size N.
 * <p>
 * Output Format:
 * <p>
 * Return an integer representing the minimum number of switches required.
 * <p>
 * Constraints:
 * <p>
 * 1 <= N <= 5e5
 * 0 <= A[i] <= 1
 * <p>
 * Example:
 * <p>
 * Input 1:
 * A = [1]
 * <p>
 * Output 1:
 * 0
 * <p>
 * Explanation 1:
 * There is no need to turn any switches as all the bulbs are already on.
 * <p>
 * Input 2:
 * A = [0 1 0 1]
 * <p>
 * Output 2:
 * 4
 * <p>
 * Explanation 2:
 * press switch 0 : [1 0 1 0]
 * press switch 1 : [1 1 0 1]
 * press switch 2 : [1 1 1 0]
 * press switch 3 : [1 1 1 1]
 */
public class Bulbs {
    public int bulbs(ArrayList<Integer> A) {
        int count = 0;
        int flag = 0;
        for (int i = 0; i < A.size(); i++) {
            if (flag == A.get(i)) {
                count++;
                flag = flag == 0 ? 1 : 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Bulbs obj = new Bulbs();
        System.out.println(obj.bulbs(new ArrayList<>(List.of(0, 1, 0, 1))));
        System.out.println(obj.bulbs(new ArrayList<>(List.of(1))));
    }
}
