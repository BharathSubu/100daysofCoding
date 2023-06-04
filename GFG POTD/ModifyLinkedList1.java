public class ModifyLinkedList1 {
    static Node root = null;

    public static Node modifyTheList(Node head)
    {
        root = head;
        Node temp = head;
        traverse(temp);
        return head;
    }

    static boolean traverse(Node temp){
        if(temp == null) return false;
        boolean is = traverse(temp.next);
        if(is) return true;
        if(temp == root || root == temp.next) return true;
        int change = temp.data - root.data;
        temp.data = root.data;
        root.data = change;
        root = root.next;
        return false;
    }

    class Node{
        int data;
        Node next;
    }
}
