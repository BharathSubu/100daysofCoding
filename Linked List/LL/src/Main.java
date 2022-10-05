public class Main {
    public static void main(String[] args) {
       LLBasics list1 = new LLBasics();
//
        list1.insertLast(10);
        list1.insertLast(20);
        list1.insertLast(30);
        list1.insertLast(40);
        list1.insertLast(50);

        list1.display();

        LLBasics list2 = new LLBasics();
//
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(4);
        list2.insertLast(5);

        list2.display();

//        merge.display();
     list2.reverse();
     list2.display();
     LLBasics merge =new LLBasics();
     merge.head = list1.mergesort(list2.head,list2.head);
     merge.display();
//        System.out.println(list.deleteLast());
//
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();
//        DLL list = new DLL();
//
//        list.insertFirst(10);
//        list.insertFirst(20);
//        list.insertFirst(30);
//        list.insertFirst(40);
//        list.insertLast(50);
//        list.insert(2,100);
//        list.display();
//        list.displayRev();
    }
}
