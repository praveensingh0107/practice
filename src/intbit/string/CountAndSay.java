package intbit.string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * <p>
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 * <p>
 * 21 is read off as one 2, then one 1 or 1211.
 * <p>
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 * <p>
 * Example:
 * <p>
 * if n = 2,
 * the sequence is 11.
 */
public class CountAndSay {
    public static String countAndSay(int a) {
        if (a <= 0)
            return "";
        StringBuilder result = new StringBuilder("1");
        StringBuilder current;
        int count;
        for (int i = 1; i < a; i++) {
            count = 1;
            int j;
            current = new StringBuilder();
            for (j = 1; j < result.length(); j++) {
                if (result.charAt(j - 1) != result.charAt(j)) {
                    current.append(count).append(result.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            current.append(count).append(result.charAt(j - 1));
            result = current;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
