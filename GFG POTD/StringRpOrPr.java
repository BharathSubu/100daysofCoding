//https://practice.geeksforgeeks.org/problems/d25f415de2ff3e02134de03e17ad019d723ab2e9/1
import java.util.*;
public class StringRpOrPr {
    static long solve(int x,int y, String s)
    {
        String s1 = "pr",s2 = "rp";
        if(x < y) {
            String t = s1;
            s1 = s2;
            s2 = t;
            int temp = x;
            x = y;
            y = temp;
        }
        Stack<Character> st = new Stack<>();
        int i =  s.length() -1;
        long ans = 0;
        while (i>=0){

            char curr = s.charAt(i);
            char first = s1.charAt(0);
            char second = s1.charAt(1);

            if(st.size() > 0 &&  curr == first && st.peek() == second){
                st.pop();
                ans+=x;
            }
            else st.push(curr);
            i--;
        }
        StringBuilder rem = new StringBuilder();
        while (!st.isEmpty()) rem.append(st.pop());
        s = rem.toString();
        i = 0;
        while (i < s.length()){

            char curr = s.charAt(i);
            char first = s1.charAt(0);
            char second = s1.charAt(1);

            if(st.size() > 0 &&  curr == first && st.peek() == second){
                st.pop();
                ans+=y;
            }
            else st.push(curr);
            i++;
        }
        return ans;
    }
}
