package intbit.heapsandmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.
 *
 * Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.
 *
 * For example,
 *
 * K = 3
 * N = 2
 * A = 6 5
 *
 * Return: 14
 * At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
 * At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
 * At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
 * so, total number of chocolates eaten: 6 + 5 + 3 = 14
 *
 * Note: Return your answer modulo 10^9+7
 */
public class MagicianAndChocolates {

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(((o1, o2) -> o2-o1));
        B.stream().forEach(pq::add);
        long res = 0;
        int val = 0;
        int mod = 1000000007;
        for (int i = 0; i < A; i++) {
            val = pq.poll();
            res = (res+ val)%mod;
            pq.add((int)Math.floor(val/2));
        }
        return (int)(res);
    }
    public static void main(String[] args) {
        MagicianAndChocolates obj = new MagicianAndChocolates();
        ArrayList<Integer> B = new ArrayList<>(List.of(2147483647, 2000000014, 2147483647));
        System.out.println(obj.nchoc(10, B));

    }
}
