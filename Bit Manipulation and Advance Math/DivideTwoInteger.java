import javax.swing.plaf.metal.MetalTheme;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoInteger {

    static  int divide(int dividend, int divisor) {
        //checking for over flow
        if(dividend == 1<<31 && divisor == -1) return  Integer.MAX_VALUE;
        //sign of the result
        boolean sign = (divisor >= 0 == dividend>=0 ) ? true : false ;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend - divisor >= 0){
            int count = 0;
            while(dividend - (divisor << 1 << count) >=0){
                count++;
            }
            result+= 1<< count;
            dividend -= divisor << count;
        }
        if(sign) return result;
        else return  -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }
}
