public class LLBasics {

     Node head;
    private Node tail;
    private  int size;

    public LLBasics(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node temp = new Node(val);
        temp.next = head;
        head = temp;

        if(tail == null){
            tail = head;
        }

        size+=1;
    }

    public  void insertLast(int val){
        if(tail == null) {
            insertFirst(val);
            return;
        }
        Node temp = new Node(val);
        tail.next = temp;
        tail = temp;
        size++;
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
                Node newnode = new Node(val,temp.next);
                temp.next = newnode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }
    public void insertRec(int pos , int val ){
            head = insertRec(pos , val ,head);
//        if(pos == 0){
//            Node temp = new Node(val);
//            temp.next = curr;
//            if(prev!=null)
//            prev.next = temp;
//            return;
//        }
//        insertRec(--pos,val,curr.next,curr);
    }

    private Node insertRec(int pos, int val, Node node) {
        if(pos == 0 ){
            Node temp = new Node(val , node);
            size++;
            return temp;
        }
        node.next = insertRec(--pos, val , node.next);
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
           tail =null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node temp = get(size - 2);
        int val = tail.value;
        tail = temp;
        tail.next = null;
        size--;
        return val;
    }
    public int delete(int index){
        if(index <= 0) return deleteFirst();
        if(index >= size - 1) return deleteLast();

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public Node get(int index){
        Node temp = head;
        for (int i = 0 ; i<index ; i++) temp = temp.next;
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print( temp.value + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public Node find(int val){
        Node temp = head;
        while(temp!=null){
            if(temp.value == val) return temp;
            temp = temp.next;
        }
        return null;
    }

    private class Node{
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
        Node(int value , Node next){
            this.value = value;
            this.next = next;
        }
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node temp1 , temp2;
        if(list1.value < list2.value){
            temp1 = list1;
            temp2 = list2;
        }
        else{
            temp2 = list1;
            temp1 = list2;
        }
        Node head = temp1;
        Node curr = temp1;
        while(temp1 !=null &&  temp2 !=null){

            if(temp1.value <= temp2.value){
                curr = temp1;
                temp1= temp1.next;
            }
            else if (temp1.value > temp2.value){

                Node ins = new Node(temp2.value);
                ins.next = temp1;
                curr.next = ins;
                curr = ins;
                temp2 = temp2.next;
            }
        }
        while(temp1!=null ){
            curr.next = temp1;
            curr = curr.next;
            temp1 = temp1.next;
        }
        while(temp2!=null ){
            curr.next = temp2;
            curr = curr.next;
            temp2 = temp2.next;
        }
        return head;
    }
//    public static LLBasics merge(LLBasics first, LLBasics second) {
//        Node f = first.head;
//        Node s = second.head;
//
//        LLBasics ans = new LLBasics();
//
//        while (f != null && s != null) {
//            if (f.value < s.value) {
//                ans.insertLast(f.value);
//                f = f.next;
//            } else {
//                ans.insertLast(s.value);
//                s = s.next;
//            }
//        }
//
//        while (f != null) {
//            ans.insertLast(f.value);
//            f = f.next;
//        }
//
//        while (s != null) {
//            ans.insertLast(s.value);
//            s = s.next;
//        }
//
//        return ans;
//    }
//    public Node mergesort(Node start,Node start1){
//        Node mid = getMid(start);
//        Node end = getEnd(start);
//        start = mergesort(start,mid);
//        mid = mergesort(mid.next,end);
//        return mergeLLsort(start,mid,end);
//    }

    public Node mergeLLsort(Node start , Node mid , Node end){
        Node list1 = start;
        Node list2 = mid.next;
        Node temp1 , temp2;
        if(list1.value < list2.value){
            temp1 = list1;
            temp2 = list2;
        }
        else{
            temp2 = list1;
            temp1 = list2;
        }
        Node head = temp1;
        Node curr = temp1;
        while(temp1 !=null &&  temp2 !=null){
            System.out.println(temp1.value + " " + temp2.value);
            if(temp1.value <= temp2.value){
                curr = temp1;
                temp1= temp1.next;
            }
            else if (temp1.value > temp2.value){

                Node ins = new Node(temp2.value);
                ins.next = temp1;
                curr.next = ins;
                curr = ins;
                temp2 = temp2.next;
            }
        }
        while(temp1!=null ){
            curr.next = temp1;
            curr = curr.next;
            temp1 = temp1.next;
        }
        while(temp2!=null ) {
            curr.next = temp2;
            curr = curr.next;
            temp2 = temp2.next;
        }
        return head;
    }

    public Node getMid(Node start){
        Node slow = start;
        Node fast = start;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node getEnd(Node start){
        Node temp = start;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public Node reverse(){
        Node newnode = head;
        Node curr = head;
        Node prev = null;
        while( curr!=null ){
            newnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnode;
        }
        head = prev;
        return head;
    }


    public static void main(String[] args) {

    }
}
