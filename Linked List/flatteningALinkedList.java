//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG {
    Node flatten(Node root) {
        int n = getlength(root);
        Node comb = root;
        Node temp = root.next;
        for (int i = 0; i < n - 1; i++) {
            comb = merge(comb, temp);
            temp = temp.next;
        }
        return comb;
    }

    public Node merge(Node m1, Node m2) {
        Node temp1 = m1;
        Node temp2 = m2;
        Node prev = null;
        Node head = temp1;
        while (temp1 != null && temp2 != null) {
            if (temp1.data > temp2.data) {
                if (prev == null) {
                    Node insert = new Node(temp2.data);
                    insert.bottom = temp1;
                    prev = insert;
                    head = prev;
                    temp2 = temp2.bottom;
                } else {
                    Node insert = new Node(temp2.data);
                    insert.bottom = temp1;
                    prev.bottom = insert;
                    prev = insert;
                    temp2 = temp2.bottom;
                }
            } else {
                prev = temp1;
                temp1 = temp1.bottom;
            }
        }
        if (temp2 != null)
            prev.bottom = temp2;
        return head;
    }

    public int getlength(Node root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.next;
        }
        return count;
    }

}