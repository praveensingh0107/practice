package intbit.dp;

import java.util.HashMap;

/**
 * Evaluate Expression To True
 * Asked in:
 * Amazon
 * Given an expression, A, with operands and operators (OR , AND , XOR), in how many ways can you evaluate the expression to true, by grouping in different ways?
 * <p>
 * Operands are only true and false.
 * <p>
 * Return the number of ways to evaluate the expression modulo 103 + 3.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input will contain a string, A.
 * <p>
 * The string A, may contain these characters:
 * '|' will represent or operator
 * '&' will represent and operator
 * '^' will represent xor operator
 * 'T' will represent true operand
 * 'F' will false
 * Output:
 * <p>
 * Return an integer, representing the number of ways to evaluate the string.
 * Constraints:
 * <p>
 * 1 <= length(A) <= 150
 * Example:
 * <p>
 * Input 1:
 * A = "T|F"
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * The only way to evaluate the expression is:
 * => (T|F) = T
 * <p>
 * Input 2:
 * A = "T^T^F"
 * <p>
 * Output 2:
 * 0
 * <p>
 * Explanation 2:
 * There is no way to evaluate A to a true statement.
 */
public class EvaluateExpressionToTrue {
    public int cnttrue(String A) {
        return countExpression(A, true, new HashMap<String, Integer>());
    }

    public int countExpression(String str, boolean isTrue, HashMap<String, Integer> hashMap) {
        if (str.length() == 0)
            return 0;
        if (str.length() == 1) {
            return stringToBoolean(str) == isTrue ? 1 : 0;
        }
        if (hashMap.containsKey(isTrue + str))
            return hashMap.get(isTrue + str);
        int count = 0;
        int mod = 1003;
        for (int i = 1; i < str.length(); i += 2) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1, str.length());
            int leftTrue = countExpression(left, true, hashMap);
            int leftFalse = countExpression(left, false, hashMap);
            int rightTrue = countExpression(right, true, hashMap);
            int rightFalse = countExpression(right, false, hashMap);
            int total = ((leftTrue + leftFalse) * (rightTrue + rightFalse)) % mod;
            int totalTrue = 0;
            if (str.charAt(i) == '|') {
                totalTrue = (((leftTrue * rightTrue) % mod + (leftFalse * rightTrue) % mod
                        + (leftTrue * rightFalse) % mod)) % mod;
            } else if (str.charAt(i) == '&') {
                totalTrue = (leftTrue * rightTrue) % mod;
            } else {
                totalTrue = (((leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod)) % mod;
            }
            count += isTrue ? totalTrue : (total - totalTrue);
        }
        hashMap.put(isTrue + str, count % mod);
        return count % mod;
    }

    private boolean stringToBoolean(String str) {
        return str.charAt(0) == 'T' ? true : false;
    }

    public static void main(String[] args) {
        EvaluateExpressionToTrue obj = new EvaluateExpressionToTrue();
        System.out.println(obj.cnttrue("T|F"));
        System.out.println(obj.cnttrue("T^T^F"));
        System.out.println(obj.cnttrue("T^T^T^F|F&F^F|T^F^T"));
    }
}
