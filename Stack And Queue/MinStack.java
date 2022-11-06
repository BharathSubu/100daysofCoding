//https://leetcode.com/problems/min-stack/submissions/837888242/
import java.util.*;

class Pair{
    int first;
    int second;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

public class MinStack {

    Stack<Pair> st = new Stack<>();
    int minval = Integer.MIN_VALUE;
    public MinStack(){
    }

    public void push(int val) {
        if(val < minval) {
            minval = val;
        }
        st.push(new Pair(val , minval));
    }

    public void pop() {
        st.pop();
        minval = st.peek().second;
    }

    public int top() {
        return st.peek().first;
    }

    public int getMin() {
        return st.peek().second;
    }
}
