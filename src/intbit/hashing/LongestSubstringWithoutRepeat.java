package intbit.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String a) {
        int max = 0;
        int currentLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        Integer prev = null;
        for (int i = 0; i < a.length(); i++) {
            prev = map.get(a.charAt(i));
            if (prev == null || i - currentLength > prev)
                currentLength++;
            else {
                if (max < currentLength)
                    max = currentLength;
                currentLength = i - prev;
            }
            map.put(a.charAt(i), i);
        }
        if (max < currentLength)
            max = currentLength;
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}
