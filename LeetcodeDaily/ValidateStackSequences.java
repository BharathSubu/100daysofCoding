//https://leetcode.com/problems/validate-stack-sequences/
import java.util.*;
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> st = new Stack<>();
        int i = 0 , j = 0;
        st.push(pushed[i++]);
        while(i < n || j < n){
            if(!st.isEmpty() && j < n && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            else if(i < n){
                st.push(pushed[i++]);
            }
            else return false;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
