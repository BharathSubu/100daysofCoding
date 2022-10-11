//'https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list

/*class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    Node prev = null;
    Node curr = head;
   
    while(curr!=null){
        Node next = curr.next;
        curr.next = prev;
        curr.prev = next;
       
        prev = curr;
        curr = next;
    }
    return prev;
}
