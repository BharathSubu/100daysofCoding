//https://leetcode.com/problems/design-add-and-search-words-data-structure/
import java.util.*;
public class DesignAddAndSearchWordsDataStructure {
    WordDictionary sol = new WordDictionary();
}
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isCompleteWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        char ch [] =  word.toCharArray();
        return findPattern(0,ch,node);
    }

    public boolean findPattern(int i , char ch[] , TrieNode node){
        if(node == null) return false;
        if(i == ch.length ) return node.isCompleteWord;
        if(ch[i] == '.'){
            for (TrieNode child : node.children) {
                if (findPattern(i+1,ch,child)) {
                    return true;
                }
            }
            return false;
        }
        TrieNode child = node.children[ch[i] - 'a'];
        if (child == null) {
            return false;
        }
        return findPattern(i+1,ch,child);
    }
}

class TrieNode {
    boolean isCompleteWord;
    TrieNode[] children;

    public TrieNode() {
        isCompleteWord = false;
        children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */