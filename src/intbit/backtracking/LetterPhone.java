package intbit.backtracking;

import java.util.ArrayList;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * The digit 0 maps to 0 itself.
 * The digit 1 maps to 1 itself.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Make sure the returned strings are lexicographically sorted.
 * */
public class LetterPhone {
    public ArrayList<String> letterCombinations(String a) {
        ArrayList<String> res = new ArrayList<String>();
        String[] arr = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations(res, new StringBuilder(), arr, a, 0);
        return res;
    }

    private void letterCombinations(ArrayList<String> res, StringBuilder sb,
            String[] arr, String a, int index) {
        if (sb.length() == a.length()) {
            res.add(sb.toString());
        } else {
            int digit = a.charAt(index) - '0';
            for (int i = 0; i < arr[digit].length(); i++) {
                sb.append(arr[digit].charAt(i));
                letterCombinations(res, sb, arr, a, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterPhone obj = new LetterPhone();
        System.out.println(obj.letterCombinations("23"));
    }
}
