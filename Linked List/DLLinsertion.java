// https://practice.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insert-a-node-in-doubly-linked-list

class GfG {
    // Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data) {
        pos += 1;
        Node insert = new Node(data);

        Node prev = null;
        Node temp = head_ref;
        while (pos > 0) {
            prev = temp;
            if (temp != null)
                temp = temp.next;
            pos--;
        }
        insert.prev = prev;
        insert.next = temp;
        if (temp != null)
            temp.prev = insert;
        prev.next = insert;

    }
}
