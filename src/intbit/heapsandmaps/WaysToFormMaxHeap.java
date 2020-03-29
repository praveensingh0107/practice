package intbit.heapsandmaps;

import java.util.Arrays;

/**
 * Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link
 *
 * So now the problem statement for this question is:
 *
 * How many distinct Max Heap can be made from n distinct integers
 *
 * In short, you have to ensure the following properties for the max heap :
 *
 * Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. )
 * Every node is greater than all its children
 * Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers
 *
 * Following are the possible max heaps from these 4 numbers :
 */
public class WaysToFormMaxHeap {

    public int solve(int A) {
        int mod = 1000000007;
        long[][] nck = new long[A+1][A+1];
        long[] dp = new long[A+1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < nck.length; i++)
            for (int j = 0; j < nck[0].length; j++)
                nck[i][j] = -1;
        return (int)solve(A, nck, dp, mod);
    }

    private long solve(int n, long[][] nck, long[] dp, int mod) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        int l = getLeft(n);
        int r = n-1-l;
        long comb = getCombination(n-1, l, nck, mod);
        long ans = (comb*((solve(l, nck, dp, mod)*solve(r, nck, dp, mod))%mod))%mod;
        dp[n] = ans;
        return ans;
    }

    private long getCombination(int n, int k, long[][] nck, int mod) {
        if (k > n || k < 0)
            return 0;
        else if (n <= 1)
            return 1;
        else if (k ==0)
            return 1;
        else if (nck[n][k] != -1)
            return nck[n][k];
        long ans = (getCombination(n-1, k, nck, mod) + getCombination(n-1, k-1, nck,mod))%mod;
        nck[n][k] = ans;
        return ans;
    }

    private int getLeft(int n) {
        int h = (int)(Math.log10(n)/Math.log10(2));
        int m = 1<<h;
        int p = n - (m - 1);
        int l = 0;
        if (p >= m/2)
            l = m - 1;
        else
            l = m -1 - (m/2 - p);
        return l;
    }

    public static void main(String[] args) {
        WaysToFormMaxHeap obj = new WaysToFormMaxHeap();
        System.out.println(obj.solve(9));
        System.out.println(obj.solve(20));
        System.out.println(obj.solve(100));
        System.out.println(obj.solve(80));
        /**
         * Your Input: 100
         * Expected output is 812145033
         *
         * Your Input: 80
         * Expected output is 807013270
         */

    }
}
