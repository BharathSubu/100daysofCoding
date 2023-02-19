//https://leetcode.com/problems/add-to-array-form-of-integer/
import java.util.*;
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int i = num.length-1;
        int carry = 0;
        while( i >= 0 || k!=0 || carry!=0){
            int sum ;
            if(i>=0)
            sum = k%10 + carry + num[i];
            else
            sum = k%10 + carry ;
//            System.out.println(sum);
           if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }
            else carry = 0;
            res.add(sum);
            i--;
            k/=10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger sol = new AddToArrayFormOfInteger();
        int []num = {2,1,5}; int k = 0;
        System.out.println(sol.addToArrayForm(num,k));
    }
}
