package intbit.dp;

/**
 * Stairs
 * Asked in:
 * Morgan Stanley
 * Amazon
 * Intel
 * You are climbing a stair case and it takes A steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument contains an integer A, the number of steps.
 * Output Format:
 *
 * Return an integer, representing the number of ways to reach the top.
 * Constrains:
 *
 * 1 <= A <= 36
 * Example :
 *
 * Input 1:
 *
 * A = 2 Output 1:
 *
 * 2 Explanation 1:
 *
 * [1, 1], [2] Input 2:
 *
 * A = 3 Output 2:
 *
 * 3 Explanation 2:
 *
 * [1 1 1], [1 2], [2 1]
 */
public class Stairs {

    public int climbStairsRec(int A) {
        if (A == 0 || A == 1)
            return 1;
        return climbStairsRec(A-2) + climbStairsRec(A-1);
    }

    public int climbStairs(int A) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 1; i < A; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        Stairs obj = new Stairs();
        System.out.println(obj.climbStairsRec(2));
        System.out.println(obj.climbStairsRec(3));
        System.out.println(obj.climbStairsRec(4));
        System.out.println(obj.climbStairsRec(5));
        System.out.println(obj.climbStairs(2));
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
        System.out.println(obj.climbStairs(5));
    }
}
