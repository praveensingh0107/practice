package intbit.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Highest Product
 * Asked in:
 * Coursera
 * Amazon
 * Given an array A, of N integers A.
 * <p>
 * Return the highest product possible by multiplying 3 numbers from the array.
 * <p>
 * NOTE: Solution will fit in a 32-bit signed integer.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument is an integer array A.
 * <p>
 * Output Format:
 * <p>
 * Return the highest possible product.
 * <p>
 * Constraints:
 * <p>
 * 1 <= N <= 5e5
 * <p>
 * Example:
 * <p>
 * Input 1:
 * A = [1, 2, 3, 4]
 * <p>
 * Output 1:
 * 24
 * <p>
 * Explanation 1:
 * 2 * 3 * 4 = 24
 * <p>
 * Input 2:
 * A = [0, -1, 3, 100, 70, 50]
 * <p>
 * Output 2:
 * 350000
 * <p>
 * Explanation 2:
 * 70 * 50 * 100 = 350000
 */
public class HighestProduct {
    public int maxp3(ArrayList<Integer> A) {
        if (A.size() == 3)
            return A.get(0) * A.get(1) * A.get(2);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2, Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if (minHeap.size() < 3 || minHeap.peek() < A.get(i)) {
                if (minHeap.size() == 3)
                    minHeap.poll();
                minHeap.offer(A.get(i));
            }
            if (A.get(i) < 0) {
                if (maxHeap.size() < 2 || maxHeap.peek() > A.get(i)) {
                    if (maxHeap.size() == 2)
                        maxHeap.poll();
                    maxHeap.add(A.get(i));
                }
            }
        }

        int product = 1;
        int last = 1;
        while (!minHeap.isEmpty()) {
            last = minHeap.poll();
            product *= last;
        }
        int product1 = 1;
        if (maxHeap.size() == 2) {
            product1 = maxHeap.poll() * maxHeap.poll() * last;
        }
        return Math.max(product, product1);
    }

    public static void main(String[] args) {
        HighestProduct obj = new HighestProduct();
        System.out.println(obj.maxp3(new ArrayList<>(List.of(1, 2, 3, 4))));
        System.out.println(obj.maxp3(new ArrayList<>(List.of(0, -1, 3, 100, 70, 50))));
        System.out.println(obj.maxp3(new ArrayList<>(List.of(-1, -2, -3, -4, -5))));
    }
}
