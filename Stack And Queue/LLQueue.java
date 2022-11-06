//https://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-queue-using-linked-list
class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}
public class LLQueue {
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
       if(front == null){
           front = new QueueNode(a);
           rear = front;
       }
       else{
          QueueNode temp = new QueueNode(a);
           rear.next = temp;
           temp = rear;
       }
    }

    //Function to pop front element from the queue.
    int pop()
    {
        if(front == null) return -1;
        int num = front.data;
        front = front.next;
        return num;
    }
}
