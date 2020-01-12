package intbit.backtracking;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *     ["a","a","b"]
 *     ["aa","b"],
 *   ]
 *  Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 * *
 * *
 * *
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 * In the given example,
 * ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 * */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        partition(res, a, 0, new ArrayList<String>());
        return res;
    }

    private void partition(ArrayList<ArrayList<String>> listOfPalindromes, String str, int index, ArrayList<String> palindromes) {
        if (index  == str.length()) {
            listOfPalindromes.add((ArrayList<String>) palindromes.clone());
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < str.length(); i++) {
                sb.append(str.charAt(i));
                if (isPalindrome(sb.toString())) {
                    palindromes.add(sb.toString());
                    partition(listOfPalindromes, str, i + 1, palindromes);
                    palindromes.remove(palindromes.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i) != str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        System.out.println(obj.partition("aba"));
        System.out.println(obj.partition("abba"));
        System.out.println(obj.partition("aab"));
    }
}
