import java.util.*;

public class WordBreak {

    StringBuilder str = new StringBuilder();

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    boolean wordBreak(String s, List<String> wordDict, int posi) {

        if (posi == s.length()) {
            if (wordDict.contains(str.toString())) {
                return true;
            }
            return false;
        }
        if (wordDict.contains(str.toString())) {
            StringBuilder now = new StringBuilder(str);
            str = new StringBuilder();
            if (wordBreak(s, wordDict, posi + 1)) {
                return true;
            }
            str = new StringBuilder(now);
            return wordBreak(s, wordDict, posi + 1);
        } else {
            while ( !wordDict.contains(str.toString()) && posi < s.length() - 1) {
                str.append(s.charAt(posi++));
            }
            return wordBreak(s, wordDict, posi + 1);
        }
    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        String[] array = { "cats", "dog", "sand", "and", "cat" };
        List<String> wordDict = new ArrayList<>(Arrays.asList(array));
        System.out.println(sol.wordBreak("catsandog", wordDict));
    }
}