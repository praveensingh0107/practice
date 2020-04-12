package intbit.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Hotel Reviews
 * Asked in:
 * Booking.com
 * Problem Setter: ishubansal Problem Tester: raghav_aggiwal
 * Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.
 *
 * Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.
 *
 *  You are expected to use Trie in an Interview for such problems
 *
 * Constraints:
 *
 * 1.   1 <= No.of reviews <= 200
 * 2.   1 <= No. of words in a review <= 1000
 * 3.   1 <= Length of an individual review <= 10,000
 * 4.   1 <= Number of Good Words <= 10,000
 * 5.   1 <= Length of an individual Good Word <= 4
 * 6.   All the alphabets are lower case (a - z)
 * Input:
 *
 * S : A string S containing "Good Words" separated by  "_" character. (See example below)
 * R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
 * Output:
 *
 * A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.
 *
 * V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
 * In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
 * Example:
 *
 * Input:
 * S = "cool_ice_wifi"
 * R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]
 *
 * Output:
 * ans = [2, 0, 1]
 * Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
 */
public class HotelReviews {
    static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        static class TrieNode {
            TrieNode[] children = new TrieNode[26];//since in problem chars are between a-z
            boolean isEndOfWord;
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null)
                    return false;
                current = current.children[index];
            }
            return current.isEndOfWord;
        }
    }

    static class Result {
        Integer reviewIndex = -1;
        Integer goodnessValue = 0;
        Result(int reviewIndex, int goodnessValue) {
            this.reviewIndex = reviewIndex;
            this.goodnessValue = goodnessValue;
        }
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<Result> results = new ArrayList<>();
        String[] words = A.split("_");
        Trie trie = new Trie();
        //prepare trie
        for (String word : words)
            trie.insert(word);
        for (int i =0; i < B.size(); i++) {
            String b = B.get(i);
            String[] reviews = b.split("_");
            int count = 0;
            for (String review : reviews) {
                if (trie.search(review))
                    count++;
            }
            Result result = new Result(i, count);
            results.add(result);
        }
        results.sort((a, b) -> b.goodnessValue.compareTo(a.goodnessValue));
        ArrayList<Integer> v = new ArrayList<>();;
        results.forEach(result -> v.add(result.reviewIndex));
        return v;
    }

    public static void main(String[] args) {
        String s = "cool_ice_wifi";
        List<String> r = List.of("water_is_cool", "cold_ice_drink", "cool_wifi_speed");
        HotelReviews obj = new HotelReviews();
        System.out.println(obj.solve(s, new ArrayList<>(r)));
    }
}
