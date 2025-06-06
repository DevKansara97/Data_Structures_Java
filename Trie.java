
import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class Node {

        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    static Node root;

    public Trie() {
        root = new Node();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("the");
        trie.insert("there");
        trie.insert("a");
        trie.insert("their");
        trie.insert("any");

        System.out.println(trie.search("the"));
        System.out.println(trie.search("thi"));

        System.out.println(trie.startsWith("thei"));

        System.out.println(trie.wordBreak("theany"));
        System.out.println(trie.wordBreakMemoized("theanythere"));

        System.out.println(trie.countNodes(root));

        System.out.println(countUniqueSubstrings("ababa"));

        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (String word : words) {
            trie.insert(word);
        }

        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }

    void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[index].isEnd = true;
            }

            curr = curr.children[index];
        }
    }

    boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            if ((i == word.length() - 1) && (!curr.children[index].isEnd)) {
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }

    boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    boolean wordBreak(String word) {
        if (word.isEmpty()) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            String firstPart = word.substring(0, i + 1);
            String secondPart = word.substring(i + 1);

            if (search(firstPart) && wordBreak(secondPart)) {
                return true;
            }
        }

        return false;
    }

    Map<String, Boolean> memo = new HashMap<>();

    boolean wordBreakMemoized(String word) {
        if (word.isEmpty()) {
            return true;
        }

        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 0; i < word.length(); i++) {
            String firstPart = word.substring(0, i + 1);
            String secondPart = word.substring(i + 1);

            if (search(firstPart) && wordBreak(secondPart)) {
                memo.put(word, true);
                return true;
            }
        }
        memo.put(word, false);
        return false;
    }

    static int countUniqueSubstrings(String word) {
        Trie trie = new Trie();
        for (int i = 0; i < word.length(); i++) {
            String suffix = word.substring(i);
            trie.insert(suffix);
        }

        return trie.countNodes(root);
    }

    int countNodes(Node node) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                count += countNodes(node.children[i]);
            }
        }

        return count + 1;
    }

    static String ans = "";

    static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].isEnd) {
                temp.append((char) ('a' + i));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
