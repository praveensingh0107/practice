package intbit.dp;

/**
 * Ways to Decode
 * Asked in:
 * Facebook
 * Amazon
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument is a string A.
 * Output Format:
 *
 * Return an integer, representing the number of ways to decode the string.
 * Constraints:
 *
 * 1 <= length(A) <= 1e5
 * Example :
 *
 * Input 1:
 *     A = "8"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Given encoded message "8", it could be decoded as only "H" (8).
 *
 *     The number of ways decoding "8" is 1.
 *
 * Input 2:
 *     A = "12"
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 *
 *     The number of ways decoding "12" is 2.
 */
public class WaysToDecode {
    public int numDecodingsRecu(String A) {
        return numDecodingsRecu(A, A.length());
    }

    private int numDecodingsRecu(String a, int length) {
        if (length < 0)
            return 0;
        else if (length == 0)
            return 1;
        int subString1 = a.charAt(length - 1) - '0';
        int subString2 = 0;
        if (length > 1) {
            subString2 = a.charAt(length -2) - '0';
            if (subString2 != 0)
                subString2 = 10*subString2 + subString1;
        }
        int res = 0;
        if (subString1>0 && subString1 < 27)
            res = numDecodingsRecu(a, length-1);
        if (subString2 > 0 && subString2 < 27)
            res += numDecodingsRecu(a, length - 2);
        return res;
    }

    public int numDecodings(String A) {
        if (A== null || A.length() == 0)
            return 0;
        int[] dp = new int[A.length() + 1];
        dp[0] = 1;
        if (A.charAt(0) != '0')
            dp[1] = 1;
        for (int i = 2; i <= A.length(); i++) {
            int first = Integer.parseInt(A.substring(i-1,i));
            int second = Integer.parseInt(A.substring(i-2, i));
            if (first>=1 && first<=9)
                dp[i] += dp[i-1];
            if (second>=10 && second<=26)
                dp[i] += dp[i-2];
        }
        return dp[A.length()];
    }

    public static void main(String[] args) {
        WaysToDecode obj = new WaysToDecode();
        System.out.println(obj.numDecodingsRecu("1234"));
        System.out.println(obj.numDecodingsRecu("123"));
        System.out.println(obj.numDecodingsRecu("1"));
        System.out.println(obj.numDecodingsRecu("102"));
        System.out.println(obj.numDecodingsRecu("012"));
        System.out.println(obj.numDecodings("1234"));
        System.out.println(obj.numDecodings("123"));
        System.out.println(obj.numDecodings("1"));
        System.out.println(obj.numDecodings("102"));
        System.out.println(obj.numDecodings("012"));
    }
}
