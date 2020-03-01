package intbit.hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
 * Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
 * <p>
 * Example :
 * <p>
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class MinWindowString {

    public String minWindow_old(String S, String T) {
        char[] str = S.toCharArray();
        char[] pat = T.toCharArray();
        if (pat.length > str.length) {
            return "";
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> rmap = new HashMap<>();
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < T.length(); i++) {
            if (tmap.containsKey(pat[i])) {
                tmap.put(pat[i], tmap.get(pat[i]) + 1);
            } else {
                tmap.put(pat[i], 1);
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (rmap.containsKey(str[i])) {
                rmap.put(str[i], rmap.get(str[i]) + 1);
            } else {
                rmap.put(str[i], 1);
            }

            if (tmap.containsKey(str[i]) && rmap.get(str[i]) <= tmap.get(str[i])) {
                count++;
            }
            if (count == pat.length) {
                while (!tmap.containsKey(str[start]) || rmap.get(str[start]) > tmap
                        .get(str[start])) {
                    if (tmap.containsKey(str[start])) {
                        rmap.put(str[start], rmap.get(str[start]) - 1);
                    }
                    start++;
                }
                if (min_len > (i - start + 1)) {
                    min_len = (i - start + 1);
                    start_index = start;
                }
            }
        }
        if (start_index == -1) {
            return "";
        }
        return S.substring(start_index, start_index + min_len);

    }

    public String minWindow(String S, String T) {
        Map<Character, Integer> countMapT = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            countMapT.merge(T.charAt(i), 1, Integer::sum);
        }
        int startIndex = 0, endIndex = S.length();
        Map<Character, LinkedList<Integer>> subStringMap = new HashMap<>();
        countMapT.entrySet().stream()
                .forEach(x -> subStringMap.put(x.getKey(), new LinkedList<>()));
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (countMapT.containsKey(S.charAt(i))) {
                if (subStringMap.get(S.charAt(i)).size() == countMapT.get(S.charAt(i))) {
                    subStringMap.get(S.charAt(i)).pollFirst();
                }
                subStringMap.get(S.charAt(i)).add(i);
                count = count < T.length() ? count + 1 : count;
                if (count == T.length() && isAllCharacterFound(countMapT, subStringMap)) {
                    int sIndex = getIndex(subStringMap, false);
                    int eIndex = getIndex(subStringMap, true);
                    if (eIndex - sIndex < endIndex - startIndex) {
                        startIndex = sIndex;
                        endIndex = eIndex;
                    }
                }
            }
        }
        return (endIndex - startIndex + 1) > S.length() ?
                "" :
                S.substring(startIndex, endIndex + 1);
    }

    private boolean isAllCharacterFound(Map<Character, Integer> countMapT, Map<Character, LinkedList<Integer>> subStringMap) {
        Optional<Map.Entry<Character, Integer>> first = countMapT.entrySet().stream()
                .filter(x -> subStringMap.get(x.getKey()).size() < x.getValue()).findFirst();
        if (first.isPresent()) return false;
        else return true;
    }

    private int getIndex(Map<Character, LinkedList<Integer>> subStringMap, boolean isMax) {
        if (isMax) {
            return subStringMap.entrySet().stream().mapToInt(x -> x.getValue().peekLast() == null ?
                    Integer.MIN_VALUE :
                    x.getValue().peekLast()).max().getAsInt();
        } else {
            return subStringMap.entrySet().stream().mapToInt(x -> x.getValue().peekFirst() == null ?
                    Integer.MAX_VALUE :
                    x.getValue().peekFirst()).min().getAsInt();
        }
    }

    public static void main(String[] args) {
        MinWindowString obj = new MinWindowString();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("AAAAAA", "AA"));
        System.out.println(obj.minWindow(
                "0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes",
                "rsm2ty04PYPEOPYO5"));
        //assert (obj.minWindow("ADOBECODEBANC", "ABc") =="");
    }

}
