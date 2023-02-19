//https://practice.geeksforgeeks.org/problems/6cb0782855c0f11445b8d70e220f888e6ea8e22a/1

public class PrimeList {
    class Node{
        Node next;
        int val;
        public Node(int data){
            val=data;
            next=null;
        }
    }

    boolean isPrime(int p) {
        if(p <= 1) return false;
        for (int i=2; i*i <= p; i++) {
            if(p % i == 0) return false;
        }
        return true;
    }

    int getNearestPrime(int num) {
        if(isPrime(num)) return num;
        int left = num-1, right = num+1;
        while(left >= 0 && !isPrime(left)) { left--; }
        while(!isPrime(right)) { right++; }
        if(left < 0) return right;
        return num-left <= right-num ? left : right;
    }

    Node primeList(Node head) {
        Node temp = head;
        while(temp != null) {
            temp.val = getNearestPrime(temp.val);
            temp = temp.next;
        }
        return head;
    }
}
