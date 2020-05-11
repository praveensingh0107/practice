package intbit.greedy;

import java.util.List;

/**
 * Gas Station
 * Asked in:
 * Bloomberg
 * Google
 * DE Shaw
 * Amazon
 * Flipkart
 * Given two integer arrays A and B of size N.
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
 * ending up at i again.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * Output Format
 * <p>
 * Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * For Example
 * <p>
 * Input 1:
 * A =  [1, 2]
 * B =  [2, 1]
 * Output 1:
 * 1
 * Explanation 1:
 * If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.
 * If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 u
 */
public class GasStation {

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        if (A == null || B == null || A.size() != B.size())
            return -1;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            int gas = 0;
            int count = 0;
            for (int j = i; count < n; count++, j = (j + 1) % n) {
                gas += A.get(j) - B.get(j);
                if (gas < 0)
                    break;
            }
            if (count == n)
                return i;
        }
        return -1;
    }

    public int canCompleteCircuit_optimize(final List<Integer> A, final List<Integer> B) {
        int currentFuel = 0, remaining = 0, total = 0, start = 0;
        for (int i = 0; i < A.size(); i++) {
            remaining = A.get(i) - B.get(i);
            if (currentFuel >= 0) {
                currentFuel += remaining;
            } else {
                currentFuel = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        GasStation obj = new GasStation();
        System.out.println(obj.canCompleteCircuit_optimize(List.of(1, 2), List.of(2, 1)));
        System.out.println(obj.canCompleteCircuit_optimize(List.of(1, 2, 6), List.of(2, 1, 6)));
    }
}
