//https://practice.geeksforgeeks.org/problems/implement-queue-using-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-queue-using-array

public class ArrayQueue {
    int front, rear;
    int arr[] = new int[100005];

    ArrayQueue()
    {
        front=0;
        rear=0;
    }

    //Function to push an element x in a queue.
    void push(int x)
    {
        if(front == 0){
            arr[1] = x;
            front = 1;
            rear = 1;
            return;
        }
        arr[++rear] = x;
    }

    //Function to pop an element from queue and return that element.
    int pop()
    {
        if(front == 0) return -1;
        int num = arr[front];
        if( front == rear){
            front = 0;
            rear = 0;
            return num;
        }
        front++;
        return num;
    }
}
