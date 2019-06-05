package intbit.string;

/**
 * Minimum Characters required to make a String Palindromic
 * You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string
 * <p>
 * Example:
 * Input: ABC
 * Output: 2
 * Input: AACECAAAA
 * Output: 2
 */
public class StringPalindromic {
    public int solve(String A) {
        if (A == null || A.isBlank()) {
            return -1;
        } else if (A.length() == 1) {
            return 0;
        }
        StringBuilder rev = new StringBuilder(A);
        rev.reverse();
        StringBuilder res = new StringBuilder(A);
        res.append('$').append(rev);
        Integer[] lps = lps(res);
        return A.length() - lps[lps.length - 1];
    }

    private Integer[] lps(StringBuilder res) {
        Integer[] lps = new Integer[res.length()];
        lps[0] = 0;
        int i = 1, j = 0;
        while (i < lps.length) {
            if (res.charAt(i) == res.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = j;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        StringPalindromic stringPalindromic = new StringPalindromic();
        System.out.println(stringPalindromic.solve("ABC"));
        System.out.println(stringPalindromic.solve("AACECAAAA"));
    }
}
