package intbit.string;

/**
 * Given a string A.
 *
 * Return the string A after reversing the string word by word.
 *
 * NOTE:
 *
 * A sequence of non-space characters constitutes a word.
 *
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 *
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 *
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the string A after reversing the string word by word.
 * For Example
 *
 * Input 1:
 *     A = "the sky is blue"
 * Output 1:
 *     "blue is sky the"
 *
 * Input 2:
 *     A = "this is ib"
 * Output 2:
 *     "ib is this"
 */
public class ReverseTheString {

    public String reverseWords(String a) {
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        while (i >= 0) {
            while (i>= 0 && a.charAt(i) == ' ')
                i--;
            if (i < 0)
                break;
            int end = i;
            while (i>=0 && a.charAt(i) != ' ')
                i--;
            int start = i + 1;
            if (res.length() != 0)
                res.append(' ');
            res.append(a.substring(start, end + 1));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        ReverseTheString obj = new ReverseTheString();
        String input1 = "the sky is blue";
        String input2 = "this is ib";
        System.out.println(obj.reverseWords(input1));
        System.out.println(obj.reverseWords(input2));
    }
}
