//https://leetcode.com/problems/word-break/submissions/

import java.util.*;

public class WordBreak {

    int [] dp = new int [301];

    int helper(String s ,  List<String> wordDict , int posi){
        if(posi==s.length()) return 1;
        StringBuilder str = new StringBuilder();
        if(dp[posi] != -1) return dp[posi];
        for(int j = posi ; j < s.length() ; j++){
            str.append(s.charAt(j));
            if(wordDict.contains(str.toString())){
                if(helper(s, wordDict, j+1) == 1) return dp[posi] = 1;
            }
        }
        return dp[posi] = 0;  
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Arrays.fill (dp, -1);
        if(helper(s, wordDict, 0)==1) return true;
        return false;
    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        String[] array = { "cats", "dog", "sand", "and", "cat" };
        List<String> wordDict = new ArrayList<>(Arrays.asList(array));
        System.out.println(sol.wordBreak("catsandog", wordDict));
    }
}