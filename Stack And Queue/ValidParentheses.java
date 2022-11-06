//https://leetcode.com/problems/valid-parentheses/submissions/837814297/
import java.util.*;

public class ValidParentheses {
    Stack<Character> st = new Stack<>();
    HashMap<Character,Character> map = new HashMap<>();

    public boolean isValid(String s) {
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                st.add(s.charAt(i));
            }
            else{
                if(map.get(st.peek()) == s.charAt(i)){
                    st.pop();
                }
            }
        }
        if(st.size() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid("{{}}[{]"));
    }
}
