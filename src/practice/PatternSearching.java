package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternSearching {

    public static List<Integer> lps(String pattern) {
        Integer[] lps = new Integer[pattern.length()];
        //ArrayList<Integer> lps = new ArrayList<>(pattern.length());
        //		/Collections.fill(lps, 0);
        if (pattern.length() == 0) {
            return new ArrayList<>(0);
        }
        int j = 0, i = 1;
        lps[0] = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = j;
                    i++;
                }
            }
        }
        return (List<Integer>) Arrays.asList(lps);
    }

    public static void main(String[] args) {
        System.out.println(lps("aaa"));
        System.out.println(lps("AABAACAABAA"));
    }

}
