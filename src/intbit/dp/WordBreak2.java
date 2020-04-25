package intbit.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Break II
 * Asked in:
 * IBM
 * Google
 * Given a string A and a dictionary of words B, add spaces in A to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * Note : Make sure the strings are sorted in your result.
 * <p>
 * Input Format:
 * <p>
 * The first argument is a string, A.
 * The second argument is an array of strings, B.
 * Output Format:
 * <p>
 * Return a vector of strings representing the answer as described in the problem statement.
 * Constraints:
 * <p>
 * 1 <= len(A) <= 50
 * 1 <= len(B) <= 25
 * 1 <= len(B[i]) <= 20
 * Examples:
 * <p>
 * Input 1:
 * A = "b"
 * B = ["aabbb"]
 * <p>
 * Output 1:
 * []
 * <p>
 * Input 1:
 * A = "catsanddog",
 * B = ["cat", "cats", "and", "sand", "dog"]
 * <p>
 * Output 1:
 * ["cat sand dog", "cats and dog"]
 */
public class WordBreak2 {
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

        public ArrayList<String> wordBreak(String str, int startIndex) {
            if (startIndex == str.length())
                return new ArrayList<>();
            char zeroChar = (char) 0;
            TrieNode current = root;
            ArrayList<String> results = new ArrayList<>();
            int i = 0;
            for (i = startIndex; i < str.length(); i++) {
                int childIndex = str.charAt(i) - zeroChar;
                if (current.children[childIndex] == null) {
                    break;
                } else if (current.children[childIndex].isEndOfWord) {
                    ArrayList<String> childResults = wordBreak(str, i + 1);
                    String sub = str.substring(startIndex, i + 1);
                    for (String childResult : childResults) {
                        results.add(sub + " " + childResult);
                    }
                }
                current = current.children[childIndex];
            }
            if (i == str.length() && current.isEndOfWord) {
                results.add(str.substring(startIndex));
            }
            return results;
        }
    }

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        Trie obj = new Trie();
        for (String str : B) {
            obj.insert(str);
        }
        return obj.wordBreak(A, 0);
    }

    public static void main(String[] args) {
        /*Trie obj = new Trie();
        obj.insert("Cat");
        obj.insert("dog");
        System.out.println(obj.search("Cat"));
        System.out.println(obj.search("cats"));*/
        ArrayList<String> B = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));
        WordBreak2 obj = new WordBreak2();
        System.out.println(obj.wordBreak("catsanddog", B));
        ArrayList<String> B1 = new ArrayList<>(List.of("aabbb"));
        System.out.println(obj.wordBreak("b", B1));
    }
}
