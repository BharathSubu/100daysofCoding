//https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1
public class ArithmeticNumber {
    static int inSequence(int a, int b, int c){
        if(a==b) return 1;

        if(c==0) return 0;

        int temp= ((b-a)/c)+1;

        if((b-a)%c==0  && temp>0) return 1;

        return 0;
    }
}
