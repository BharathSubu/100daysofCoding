//https://leetcode.com/problems/reverse-integer/submissions/
public class RevergeInteger {

    public int reverse(int x) {
        int n = x;
        int len = 0;
        while(n!=0){
            n/=10;
            len++;
        }
        int result = 0;
        int min = -1 * (int)Math.pow(2,31);
        while(x!=0){
            int num = x%10;
            len--;
            x/=10;
            result+=num*Math.pow(10,len);
            if(result<min) return 0;
            if(result>=Integer.MAX_VALUE ) return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        RevergeInteger sol = new RevergeInteger();
        System.out.println(sol.reverse(1234));
    }
}
