package intbit.dp;

/**
 * Regular Expression II
 * Asked in:
 * Facebook
 * Microsoft
 * Google
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * <p>
 * int isMatch(const char *s, const char *p)
 * Some examples:
 * <p>
 * isMatch("aa","a") → 0
 * isMatch("aa","aa") → 1
 * isMatch("aaa","aa") → 0
 * isMatch("aa", "a*") → 1
 * isMatch("aa", ".*") → 1
 * isMatch("ab", ".*") → 1
 * isMatch("aab", "c*a*b") → 1
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class RegularExpression2 {
    public int isMatch(final String A, final String B) {
        return isMatch(A, 0, B, 0) ? 1 : 0;
    }

    private boolean isMatch(String a, int i, String b, int j) {
        if (j < 0 || i < 0)
            return false;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j) || b.charAt(j) == '.') {
                i++;
                j++;
            } else {
                if (b.charAt(j) != '*') {
                    if (j + 1 < b.length() && b.charAt(j + 1) == '*') {
                        return isMatch(a, i, b, j + 2);
                    } else {
                        return false;
                    }
                } else {
                    return isMatch(a, i - 1, b, j + 1) || isMatch(a, i, b, j - 1) || isMatch(a, i,
                            b, j + 1);
                }
            }
        }
        if (i == a.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        RegularExpression2 obj = new RegularExpression2();
        System.out.println(obj.isMatch("aa", "a"));
        System.out.println(obj.isMatch("aa", "aa"));
        System.out.println(obj.isMatch("aaa", "aa"));
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("aa", ".*"));
        System.out.println(obj.isMatch("ab", ".*"));
        System.out.println(obj.isMatch("aab", "c*a*b"));
        System.out.println(obj.isMatch("abbc", "ab*bbc"));
    }
}
