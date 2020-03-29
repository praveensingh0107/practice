package intbit.trees;

import tree.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Shortest Unique Prefix
 * Asked in:
 * Google
 * Find shortest unique prefix to represent each word in the list.
 *
 * Example:
 *
 * Input: [zebra, dog, duck, dove]
 * Output: {z, dog, du, dov}
 * where we can see that
 * zebra = z
 * dog = dog
 * duck = du
 * dove = dov
 *  NOTE
 */
public class ShortestUniquePrefix {
    static class Trie {
        Trie[] arr = new Trie[26];
        boolean isEndOfWord;
        int count = 0;
        public Trie() {
        }
        public void insert(String word) {
            Trie current = this;
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                int index = c - 'a';
                if (current.arr[index] == null)
                    current.arr[index] = new Trie();
                current.arr[index].count++;
                current = current.arr[index];
            }
            current.isEndOfWord = true;
        }

        public String getUniqueString(String word) {
            StringBuilder sb = new StringBuilder();
            Trie current = this;
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                int index = c - 'a';
                sb.append(c);
                if (current.arr[index] != null && current.arr[index].count > 1)
                    current = current.arr[index];
                else
                    break;
            }
            return sb.toString();
        }
    }
    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<String>();
        Trie root = new Trie();
        A.stream().forEach(root::insert);
        A.stream().forEach(x -> result.add(root.getUniqueString(x)));
        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("zebra", "dog", "duck", "dove");
        ArrayList A = new ArrayList<>(list);
        ShortestUniquePrefix obj = new ShortestUniquePrefix();
        System.out.println(obj.prefix(A));
    }
}
