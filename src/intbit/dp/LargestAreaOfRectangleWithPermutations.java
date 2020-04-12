package intbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Largest area of rectangle with permutations
 * Asked in:
 * Directi
 * Problem Setter: amitkgupta94 Problem Tester: RAMBO_tejasv
 * Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns matrix i.e. you can arrange each of the column in any order in the final grid. Please follow the below example for more clarity.
 *
 * Lets say we are given a binary grid of 3 * 3 size.
 *
 * 1 0 1
 *
 * 0 1 0
 *
 * 1 0 0
 *
 * At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the given matrix, we can take column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:
 *
 * 1 1 0
 *
 * 0 0 1
 *
 * 1 0 0
 *
 * Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given grid. Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger than the earlier case. Hence 2 will be the answer in this case.
 */
public class LargestAreaOfRectangleWithPermutations {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        int[][] matrix = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                matrix[i][j] = A.get(i).get(j);
            }
        }
        //count number of consecutive 1 in every columns;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];
            }
        }
        //sort each row in decreasing order of column count
        for (int i = 0; i< matrix.length; i++) {
            //System.out.println("matrix before sorting: " + Arrays.toString(matrix[i]));
            countSort(matrix, i); //sort each row
        }
        //calculate max area
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            int currentArea = 0;
            for (int j = 0; j<matrix[i].length; j++) {
                currentArea = matrix[i][j] * (j + 1);
                if (maxArea < currentArea)
                    maxArea = currentArea;
            }
        }
        return maxArea;
    }

    private void countSort(int[][] matrix, int i) {
        int[] count = new int[matrix.length + 1];
        int[] output = new int[matrix[i].length];
        //get count
        //System.out.println("before count: " + Arrays.toString(count));
        for (int j = 0; j < matrix[i].length; j++) {
            count[matrix[i][j]]++;
        }
        //System.out.println("after count: " + Arrays.toString(count));
        //
        for (int j = 1; j < count.length; j++) {
            count[j] += count[j-1];
        }

        for (int j = output.length -1; j >= 0; j--) {
            output[count[matrix[i][j]] -1] = matrix[i][j];
            count[matrix[i][j]]--;
        }

        //saved in reverse order
        for (int j = 0; j < output.length; j++) {
            matrix[i][output.length -j -1] = output[j];
        }
        //System.out.println("matrix after sorting: " + Arrays.toString(matrix[i]));
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A= new ArrayList<>();
        List<Integer> l1 = List.of(1, 1, 0, 0, 0);
        List<Integer> l2 = List.of(1, 1, 1, 1, 1);
        List<Integer> l3 = List.of(1, 0, 1, 1, 1);
        ArrayList<Integer> r1 = new ArrayList<>(l1);
        ArrayList<Integer> r2 = new ArrayList<>(l2);
        ArrayList<Integer> r3 = new ArrayList<>(l3);
        A.add(r1); A.add(r2); A.add(r3);
        List<Integer> columnOrder = List.of(0,1,2);
        List<Integer> columnOrder2 = List.of(0,2,1);
        LargestAreaOfRectangleWithPermutations obj = new LargestAreaOfRectangleWithPermutations();
        System.out.println(obj.solve(A));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(new ArrayList<>());;
        System.out.println(obj.solve(B));
        //System.out.println(obj.getArea(A, columnOrder2));
        //System.out.println(obj.solve(A));
    }
}
