//https://leetcode.com/problems/add-digits/
import java.util.*;
public class AddDigits {
    public int addDigits(int num) {
        while(num >= 10){
            int sum = 0;
            while(num!= 0){
                sum+=num%10;
                num/=10;
            }
            num = sum;
        }
        return num;
    }
}
