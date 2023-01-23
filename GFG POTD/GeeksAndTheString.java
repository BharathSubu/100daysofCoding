//https://practice.geeksforgeeks.org/problems/466faca80c3e86f13880710491c634d26abd44a7/1

import java.util.*;

public class GeeksAndTheString {
    public static String removePair(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(!st.isEmpty() && st.peek() == s.charAt(i)) st.pop();
            else st.push(s.charAt(i));
        }
        StringBuilder str= new StringBuilder();
        while (!st.isEmpty()) str.append(st.pop());
        return str.reverse().toString();
    }
}
