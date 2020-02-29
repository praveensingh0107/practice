package intbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * <p>
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * <p>
 * Example :
 * <p>
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        int n = B.size();
        int x = B.get(0).length();
        int windowSize = n * x; // size of substring of A
        ArrayList<Integer> result = new ArrayList<>();
        if (windowSize > A.length())
            return result;
        Map<String, Integer> map = new HashMap<>(); // to count the number of each element in B
        B.stream().forEach(i -> map.merge(i, 1, Integer::sum));
        int hashSumOfB = B.stream().map(this::hash).reduce(0, Integer::sum);
        int startIndex = 0, endIndex = windowSize;
        int hashOfSubstring = hash(A.substring(startIndex, endIndex));
        while (true) {
            if (hashOfSubstring == hashSumOfB) {
                int i;
                Map<String, Integer> subMap = new HashMap<>();
                for (i = startIndex; i < endIndex; i += x) {
                    String substring = A.substring(i, i + x);
                    if (map.get(substring) == null)
                        break;
                    subMap.merge(substring, 1, Integer::sum);
                    if (subMap.get(substring) > map.get(substring))
                        break;
                }
                if (i == endIndex) {
                    result.add(startIndex);
                }
            }
            if (endIndex == A.length())
                break;
            hashOfSubstring -= hash(A.charAt(startIndex));
            hashOfSubstring += (hash(A.charAt(endIndex)));
            startIndex++;
            endIndex++;
        }
        return result;
    }

    public int hash(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += hash(str.charAt(i));
        }
        return sum;
    }

    public int hash(char c) {
        return c - 'a';
    }

    /**
     * A : "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
     * B : [ "aaa", "aaa", "aaa", "aaa", "aaa" ]
     *
     * @param args
     */

    public static void main(String[] args) {
        SubstringConcatenation obj = new SubstringConcatenation();
        String a = "barfoothefoobarman";
        List<String> b = List.of("foo", "bar");
        System.out.println(obj.findSubstring(a, b));
        String A = "abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa";
        List<String> B = List.of("cac", "aaa", "aba", "aab", "abc");
        System.out.println(obj.findSubstring(A, B));
        String A1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> B1 = List.of("aaa", "aaa", "aaa", "aaa", "aaa");
        System.out.println(obj.findSubstring(A1, B1));
        String A2 = "bcabbcaabbccacacbabccacaababcbb";
        List<String> B2 = List.of("c", "b", "a", "c", "a", "a", "a", "b", "c");
        System.out.println(obj.findSubstring(A2, B2));
    }
}
