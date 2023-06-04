//https://leetcode.com/problems/removing-stars-from-a-string/
import java.util.*;
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') st.pop();
            else st.push(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) res.append(st.pop());
        return res.toString();
    }
}
