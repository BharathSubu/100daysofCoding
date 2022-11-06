//https://practice.geeksforgeeks.org/problems/implement-stack-using-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-stack-using-array
public class ArrayStack {
    int top;
    int arr[] = new int[1000];

    ArrayStack()
    {
        top = -1;
    }

    //Function to push an integer into the stack.
    void push(int a)
    {
        if(top == -1) {
            top = 0;
            arr[top] = a;
        }
        else{
            arr[++top] = a;
        }
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        if(top == -1) return -1;
        int num = arr[top];
        top--;
        return num;
    }
}
