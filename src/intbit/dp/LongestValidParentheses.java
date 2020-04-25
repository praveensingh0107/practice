package intbit.dp;

import java.util.Stack;

/**
 * Longest valid Parentheses
 * Asked in:
 * Google
 * Given a string A containing just the characters ’(‘ and ’)’.
 * <p>
 * Find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The only argument given is string A.
 * Output Format:
 * <p>
 * Return the length of the longest valid (well-formed) parentheses substring.
 * Constraints:
 * <p>
 * 1 <= length(A) <= 750000
 * For Example
 * <p>
 * Input 1:
 * A = "(()"
 * Output 1:
 * 2
 * Explanation 1:
 * The longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Input 2:
 * A = ")()())"
 * Output 2:
 * 4
 * Explanation 2:
 * The longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String A) {
        if (A == null || A.isEmpty())
            return 0;
        int max = 0;
        int last = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty())
                    last = i;
                else {
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, i - last);
                    else
                        max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        /*System.out.println(obj.longestValidParentheses("(()"));
        System.out.println(obj.longestValidParentheses(")()())"));
        System.out.println(obj.longestValidParentheses("((())))()"));
        System.out.println(obj.longestValidParentheses("(()))()()())((())())"));*/
        System.out.println(obj.longestValidParentheses(
                ")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
    }
}
