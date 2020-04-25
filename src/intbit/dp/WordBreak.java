package intbit.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Break
 * Asked in:
 * IBM
 * Google
 * Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Input Format:
 * <p>
 * The first argument is a string, A.
 * The second argument is an array of strings, B.
 * Output Format:
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 * Constraints:
 * <p>
 * 1 <= len(A) <= 6500
 * 1 <= len(B) <= 10000
 * 1 <= len(B[i]) <= 20
 * Examples:
 * <p>
 * Input 1:
 * A = "myinterviewtrainer",
 * B = ["trainer", "my", "interview"]
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
 * <p>
 * Input 2:
 * A = "a"
 * B = ["aaa"]
 * <p>
 * Output 2:
 * 0
 * <p>
 * Explanation 2:
 * Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
 */
public class WordBreak {
    static class TrieNode {
        TrieNode[] children = new TrieNode[256];

        boolean isEndOfWord;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String str) {
            char zeroChar = (char) 0;
            char[] arr = str.toCharArray();
            TrieNode curr = root;
            for (char c : arr) {
                int index = c - zeroChar;
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String str) {
            char zeroChar = (char) 0;
            char[] arr = str.toCharArray();
            TrieNode curr = root;
            for (char c : arr) {
                int index = c - zeroChar;
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }
            return curr.isEndOfWord;
        }

        public boolean wordBreak(String str, int startIndex) {
            if (startIndex == str.length())
                return true;
            char zeroChar = (char) 0;
            TrieNode current = root;
            int i = 0;
            for (i = startIndex; i < str.length(); i++) {
                int childIndex = str.charAt(i) - zeroChar;
                if (current.children[childIndex] == null) {
                    break;
                } else if (current.children[childIndex].isEndOfWord) {
                    if (wordBreak(str, i + 1))
                        return true;
                }
                current = current.children[childIndex];
            }
            if (i == str.length() && current.isEndOfWord) {
                return true;
            }
            return false;
        }
    }

    public int wordBreak(String A, ArrayList<String> B) {
        Trie trie = new Trie();
        for (String str : B) {
            trie.insert(str);
        }
        return trie.wordBreak(A, 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        ArrayList<String> B = new ArrayList<>(List.of("trainer", "my", "interview"));
        System.out.println(obj.wordBreak("myinterviewtrainer", B));
        ArrayList<String> B1 = new ArrayList<>(List.of("aaa"));
        System.out.println(obj.wordBreak("a", B1));
    }
}
