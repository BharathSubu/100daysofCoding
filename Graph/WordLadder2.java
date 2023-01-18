//https://leetcode.com/problems/word-ladder-ii/

import java.util.*;

public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for ( String s:wordList  ) {
            map.put(s,Integer.MAX_VALUE-1);
        }
        Queue<StringPair> qu = new LinkedList<>();
        qu.add(new StringPair(beginWord,1 , new ArrayList<>()) );
        int minstep  = wordList.size() + 1;
        while ( !qu.isEmpty() ){
            StringPair st = qu.remove();
            if(st.word.equals(endWord) && minstep >= st.step ) {
                res.add(new ArrayList<>(st.lst));
                minstep = st.step;
            }
            if(st.step > minstep) break;
            nextStep(st,qu,map,endWord);
        }
        return res;
    }

    void nextStep(StringPair s , Queue<StringPair> qu ,HashMap<String,Integer> map, String endWord){
        StringBuilder currwrd = new StringBuilder(s.word);
        for (int i = 0; i <currwrd.length(); i++) {
            StringBuilder nextwrd = new StringBuilder(currwrd);
            for (int j = 0; j < 26; j++) {
                char c = 'a';
                c+=j;
                nextwrd.setCharAt(i,c);
                if(!nextwrd.equals(currwrd) && map.containsKey(nextwrd.toString())){
//                    System.out.println(map.get(nextwrd.toString()));
                    if(map.get(nextwrd.toString()) + 1 > s.step) {
                        map.put(nextwrd.toString(),s.step + 1);
                        qu.add(new StringPair(nextwrd.toString(), s.step + 1, s.lst));
                    }
                }
            }
        }
    }

    class StringPair{
        int step;
        String word;
        List<String> lst = new ArrayList<>();
        StringPair ( String w ,int s , List<String> prev){
            step = s;
            word = w;
            lst.addAll(prev);
            lst.add(w);
        }
    }

    public static void main(String[] args) {
        WordLadder2 sol = new WordLadder2();
        String beginWord = "hit", endWord = "cog"; String[] wordList ={"hot","dot","dog","lot","log","cog"};
        System.out.println(sol.findLadders(beginWord,endWord, List.of(wordList)));
    }
}
