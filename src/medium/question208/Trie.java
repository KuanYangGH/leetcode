package medium.question208;

/**
 * Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {
    private TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TreeNode(word.charAt(i));
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    class TreeNode {
        char value;
        boolean isEnd;

        public TreeNode(char value) {
            this.value = value;
        }

        TreeNode[] children = new TreeNode[26];
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        boolean b = trie.search("apple");   // returns true
        b = trie.search("app");     // returns false
        b = trie.startsWith("app"); // returns true
        trie.insert("app");
        b = trie.search("app");     // returns true
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
