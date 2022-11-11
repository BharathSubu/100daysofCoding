import java.util.*;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(st.size()!= 0 && st.peek() == s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        while (st.size()!=0){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}
