import java.util.Stack;

//https://leetcode.com/problems/make-the-string-great/
public class MakeTheStringGreat {
    public static String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length() <= 1) return s;
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(st.size() != 0 && st.peek() - ch == 32){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        String res = "";
        for (char ch : st ) {
            res+=ch;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leeEetcode"));
    }
}
