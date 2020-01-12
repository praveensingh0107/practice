package intbit.backtracking;

import java.util.ArrayList;

/**Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 Make sure the returned list of strings are sorted.
 * */
public class GenerateAllParentheses {

    public ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> res = new ArrayList<>();
        generateParenthesis(res, "", 0, 0, a);
        return res;
    }

    private void generateParenthesis(ArrayList<String> res, String str, int l, int r, int a) {
        if (l == a) {
            for (int i = r; i < a; i++) {
                str +=")";
            }
            res.add(str);
        } else {
            generateParenthesis(res, str + "(", l+1, r, a);
            if (r < l)
                generateParenthesis(res, str + ")", l, r + 1, a);
        }
    }

    public static void main(String[] args) {
        GenerateAllParentheses obj = new GenerateAllParentheses();
        System.out.println(obj.generateParenthesis(4));
    }
}
