//https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-stack-using-linked-list
class StackNode {
     int data;
     StackNode next;
     StackNode(int a) {
         data = a;
         next = null;
     }
 }
public class LLStack {
    StackNode top;

    //Function to push an integer into the stack.
    void push(int a)
    {
       if(top == null){
           top = new StackNode(a);
           return;
       }
       StackNode temp = new StackNode(a);
       temp.next = top ;
       top = temp;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        int num = top.data;
        top = top.next;
        return num;
    }
}
