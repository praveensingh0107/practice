package intbit.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
 *
 * Bonus if you can solve it in O(n^2) or less.
 *
 * Example :
 *
 * A : [  1 1 1
 *        0 1 1
 *        1 0 0
 *     ]
 *
 * Output : 4
 *
 * As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
 */
public class MaxRectangleInBinaryMatrix {

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0)
            return 0;
        int[][] matrix = new int[A.size()][A.get(0).size()];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = A.get(r).get(c);
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (A.get(r).get(c) == 1)
                    matrix[r][c] += matrix[r-1][c];
            }
        }
        int maxArea = 0;
        for (int r = 0; r < matrix.length; r++) {
            maxArea = Math.max(maxArea, getMaxAreaInHistogram(matrix[r]));
        }
        return maxArea;
    }

    private int getMaxAreaInHistogram(int[] matrix) {
        if (matrix.length == 0)
            return 0;
        int  maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            while (!stack.isEmpty() && matrix[i] < matrix[stack.peek()]) {
                int j = stack.pop();
                int leftIndex = stack.isEmpty()? -1 : stack.peek();
                int area = matrix[j] * (i - leftIndex - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int rightIndex = matrix.length;
            int lefIndex = stack.isEmpty()? -1 : stack.peek();
            int area = matrix[j] * (rightIndex - lefIndex -1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxRectangleInBinaryMatrix obj = new MaxRectangleInBinaryMatrix();
        List<Integer> l1 = List.of(1, 1, 1);
        List<Integer> l2 = List.of(0, 1, 1);
        List<Integer> l3 = List.of(1, 0, 0);
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(l1)); a.add(new ArrayList<>(l2)); a.add(new ArrayList<>(l3));
        System.out.println(obj.maximalRectangle(a));
    }
}
