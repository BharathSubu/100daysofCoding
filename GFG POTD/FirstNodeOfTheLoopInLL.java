
// https://practice.geeksforgeeks.org/problems/44bb5287b98797782162ffe3d2201621f6343a4b/1

public class FirstNodeOfTheLoopInLL {
    //Function to find first LLNode if the linked list has a loop.
    public static int findFirstLLNode(LLNode head){
        LLNode slow = head;
        LLNode fast = head;
        boolean isFOund = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                isFOund = true;
                break;
            }
        }
        if(!isFOund) return -1;
        LLNode temp = head;
        while(temp != fast){
            temp = temp.next;
            fast = fast.next;
        }
        return temp.data;
    }
}
class LLNode
{
    int data;
    LLNode next;
    
    LLNode(int x)
    {
        data = x;
        next = null;
    }
}