//https://leetcode.com/problems/remove-k-digits/submissions/840750730/
import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i = 0;
        for ( i = 0; i < num.length(); i++) {

            char ch = num.charAt(i);
            while(st.size()!=0 && k > 0 && ch < st.peek() ){
                st.pop();
                k--;
            }
            if( !st.empty() || ch!='0'){
                st.push(ch);
            }
        }
        while ( !st.empty() && k--!=0){
            st.pop();
        }
        if(st.empty()) return "0";
        while ( !st.empty() ){
            res.insert(0,st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("14301620",4));
    }
}
