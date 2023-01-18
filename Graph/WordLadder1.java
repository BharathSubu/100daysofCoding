//https://leetcode.com/problems/word-ladder/description/

import java.util.*;

public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<StringPair> qu = new LinkedList<>();
        qu.add(new StringPair(beginWord,1));

        while ( !qu.isEmpty() ){
            StringPair st = qu.remove();
            if(st.word.equals(endWord)) return st.step;
            System.out.println(st.step);
            nextStep(st,qu,set);
        }
        return 0;
    }

    void nextStep( StringPair s ,  Queue<StringPair> qu ,  HashSet<String> set ){
        StringBuilder currwrd = new StringBuilder(s.word);
        for (int i = 0; i <currwrd.length(); i++) {
            StringBuilder nextwrd = new StringBuilder(currwrd);
            for (int j = 0; j < 26; j++) {
                char c = 'a';
                c+=j;
                nextwrd.setCharAt(i,c);
                if(!nextwrd.equals(currwrd) && set.contains(nextwrd.toString())){
                    set.remove(nextwrd.toString());
                    qu.add(new StringPair(nextwrd.toString() , s.step +1));
                }
            }
        }
    }

    class StringPair{
        int step;
        String word;
        StringPair ( String w ,int s ){
            step = s;
            word = w;
        }
    }
    public static void main(String[] args) {
        WordLadder1 sol = new WordLadder1();
        String beginWord = "hit", endWord = "cog"; String[] wordList ={"hot","dot","dog","lot","log","cog"};
        System.out.println(sol.ladderLength(beginWord,endWord, List.of(wordList)));
    }
}
