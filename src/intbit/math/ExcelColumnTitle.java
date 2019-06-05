package intbit.math;

import java.util.Stack;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int a) {
        if (a < 1)
            return "";
        Stack<Character> stack = new Stack<>();
        char val;
        int rem;
        StringBuilder sb = new StringBuilder();
        while (a != 0) {
            rem = (a - 1) % 26;
            val = (char) ('A' + rem);
            stack.push(val);
            a = (a - 1) / 26;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
        System.out.println(excelColumnTitle.convertToTitle(28));
    }
}
