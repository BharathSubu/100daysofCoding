//https://leetcode.com/contest/weekly-contest-329/problems/alternating-digit-sum/
import java.util.*;

public class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int len = String.valueOf(n).length();
        int sum =0;
        if (len%2 == 0){
            int flag = -1;
            while (n > 0){
                int rem = n%10;
                n/=10;
                sum+=(flag*rem);
                if(flag == -1) flag = 1;
                else flag = -1;
            }
        }
        else{
            int flag = 1;
            while (n > 0){
                int rem = n%10;
                n/=10;
                sum+=(flag*rem);
                if(flag == -1) flag = 1;
                else flag = -1;
            }
        }
        return sum;
    }
}
