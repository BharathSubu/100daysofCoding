//https://leetcode.com/problems/implement-queue-using-stacks/submissions/837465731/

import java.util.*;


public class MyQueue {
    Stack<Integer> instack = new Stack<Integer>();

    public MyQueue() {

    }

    public void push(int x) {
        instack.add(x);
    }

    public int pop() {
        int n = instack.size();
        Stack<Integer> outstack =  new Stack<Integer>();
        for (int i = 0; i < n ; i++) {
            outstack.add(instack.pop());
        }
        int res = outstack.pop();
        n = outstack.size();
        for (int i = 0; i < n ; i++) {
            instack.add(outstack.pop());
        }
        return res;
    }

    public int peek() {
        Stack<Integer> peekstack = new Stack<Integer>();
        int n = instack.size();
        for (int i = 0; i < n; i++) {
            peekstack.add(instack.pop());
        }
        int res = peekstack.peek();
        n = peekstack.size();
        for (int i = 0; i < n; i++) {
            instack.add(peekstack.pop());
        }
        return res;
    }

    public boolean empty() {
        return instack.empty();
    }

    public static void main(String[] args) {
        MyQueue que = new MyQueue();
        que.push(10);
        que.push(20);
        System.out.println(que.peek());
        System.out.println(que.pop());
        System.out.println(que.empty());
    }
}
