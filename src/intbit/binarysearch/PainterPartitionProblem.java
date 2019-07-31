package intbit.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.
 *
 * 2 painters cannot share a board to paint. That is to say, a board
 * cannot be painted partially by one painter, and partially by another.
 * A painter will only paint contiguous boards. Which means a
 * configuration where painter 1 paints board 1 and 3 but not 2 is
 * invalid.
 * Return the ans % 10000003
 *
 * Input :
 * K : Number of painters
 * T : Time taken by painter to paint 1 unit of board
 * L : A List which will represent length of each board
 *
 * Output:
 *      return minimum time to paint all boards % 10000003
 * Example
 *
 * Input :
 *   K : 2
 *   T : 5
 *   L : [1, 10]
 * Output : 50
 */
public class PainterPartitionProblem {
    public int paint(int A, int B, ArrayList<Integer> C) {
        long lo = C.stream().max(Integer::compareTo).get();
        if (C.size() >= A) {
            long hi = C.stream().mapToInt(Integer::intValue).sum();
            while (lo < hi) {
                long mid = lo + (hi -lo)/2;
                long getStudent = getRequiredPainters(C, mid);
                if (getStudent <= A) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        long res = (lo * B)%10000003;
        return (int)res;
    }

    private int getRequiredPainters(List<Integer> C, long maxBoardPerPainter) {
        int total = 0,count = 1;
        for (int i : C) {
            total += i;
            if (total > maxBoardPerPainter) {
                total = i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PainterPartitionProblem obj = new PainterPartitionProblem();
        List<Integer> arr = List.of(1, 10);
        System.out.println(obj.paint(1,3,new ArrayList<>(arr)));
    }
}
