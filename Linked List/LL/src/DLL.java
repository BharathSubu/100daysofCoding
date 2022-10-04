public class DLL {

    Node head ;
    private int size = 0;
    public void insertFirst(int val){
        size++;
        Node temp = new Node(val);
        if(head == null) {
            head = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        temp.prev = null;
        head = temp;
    }

    public void insertLast(int val){
        size++;
        Node temp = new Node(val);
        Node node = head;
        if(head == null) {
            head = temp;
            return;
        }
        while(node.next!=null){
            node = node.next;
        }
        node.next = temp;
        temp.prev = node;
    }

    public void insert(int pos , int val){
        if(pos == 0) {
            insertFirst(val);return;
        }
        if(pos >= size){
            insertLast(val);
            return;
        }
        Node temp = head;
        int currpos = 0;
        while(temp != null){
            currpos++;
            if(currpos == pos) {
                Node newnode = new Node(val);
                temp.next.prev = newnode;
                newnode.next = temp.next;
                temp.next = newnode;
                newnode.prev = temp;
                size++;
                return;
            }
            temp = temp.next;
        }
    }
    public  void display(){
        Node temp = head;
        while(temp != null){
            System.out.print( temp.val + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public  void displayRev(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        while(temp != null){
            System.out.print( temp.val + "<-");
            temp = temp.prev;
        }
        System.out.println("HEAD");
    }

    private class Node{
        int val;
        Node next ;
        Node prev ;

        public  Node(int val){
            this.val = val;
        }
        public  Node (int val , Node prev , Node next){
            this.val  = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
