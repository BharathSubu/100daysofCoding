//https://leetcode.com/problems/implement-stack-using-queues/submissions/837438932/
import java.util.*;

public class MyStack {
    Queue<Integer> inqueue = new LinkedList<Integer>();
    Queue<Integer> outqueue = new LinkedList<Integer>();

    public MyStack() {

    }
    public void push(int x) {
        inqueue.add(x);
    }
    public int pop() {
        int n = inqueue.size();
        for (int i = 0; i < n-1; i++) {
            inqueue.add(inqueue.remove());
        }
        int res = inqueue.peek();
        inqueue.remove();
        return res;
    }
    public int top() {
        outqueue = new LinkedList<>(inqueue);
        int n = outqueue.size();
        for (int i = 0; i < n-1; i++) {
            outqueue.remove();
        }
        return outqueue.remove();
    }

    public boolean empty() {
        if(inqueue.size() <= 0) return true;
        return false;
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

