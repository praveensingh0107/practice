package tree;

import java.util.List;

public class Trie {

    public static final int ALPAHBATE_SIZE = 26;
    static class TrieNode {
        private TrieNode[] children = new TrieNode[ALPAHBATE_SIZE];

        private boolean isEndOfword = false;

        public TrieNode[] getChildren() {
            return children;
        }

        public boolean isEndOfword() {
            return isEndOfword;
        }

        public void setEndOfword(boolean endOfword) {
            isEndOfword = endOfword;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode pCrawler = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawler.getChildren()[index] == null) {
                pCrawler.getChildren()[index] = new TrieNode();
            }
            pCrawler = pCrawler.getChildren()[index];
        }
        pCrawler.setEndOfword(true);
    }

    public boolean search(String key) {
        TrieNode pCrawler = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawler.getChildren()[index] == null) {
                return false;
            }
            pCrawler = pCrawler.getChildren()[index];
        }
        return pCrawler.isEndOfword();
    }

    public void delete(String key) {
        delete(root, key, 0);
    }

    public TrieNode delete(TrieNode root, String key, int depth) {
        if (root == null)
            return null;
        if (depth == key.length()) {
            if (root.isEndOfword())
                root.setEndOfword(false);
            if (isEmpty(root.getChildren()))
                return null;
            return root;
        }
        int index = key.charAt(depth) - 'a';
        root.getChildren()[index] = delete(root.getChildren()[index], key, depth + 1);
        if (isEmpty(root.getChildren()) && !root.isEndOfword)
            return null;
        return root;
    }

    private boolean isEmpty(TrieNode[] children) {
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> keys = List.of("all", "ally", "cat", "cats");
        Trie obj = new Trie();
        keys.forEach(obj::insert);
        keys.forEach(x -> System.out.println(obj.search(x)));
        System.out.println(obj.search("ca"));
        obj.delete("cats");
        obj.delete("all");
        keys.forEach(x -> System.out.println(obj.search(x)));
    }
}
