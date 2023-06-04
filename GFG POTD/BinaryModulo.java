//https://practice.geeksforgeeks.org/problems/7488b7721e8aa5e5fc37d56af8b9c89e329c796f/1
import java.util.*;
public class BinaryModulo {
    int modulo(String s, int m) {
        int n = s.length();
        int i = 0;
        int sum = 0;
        while (n!=0){
            n--;
            if(s.charAt(i) == '1') sum+=(int) Math.pow(2,i);
            i++;
        }
        return sum%m;
    }
}
