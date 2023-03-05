//https://practice.geeksforgeeks.org/problems/13eb74f1c80bc67d526a69b8276f6cad1b8c3401/1
import java.util.*;
public class ValidCompressedString {
    static int checkCompressed(String s, String t) {
        int i=0,j=0,sum=0;
        while(j<t.length()){
            if(Character.isAlphabetic(t.charAt(j))){
                i+=sum;
                sum=0;
                if(i<s.length() && s.charAt(i)==t.charAt(j)) {
                    i++;
                    j++;
                }
                else
                    return 0;
            }
            else{
                sum=sum*10+(t.charAt(j)-'0');
                j++;
            }
        }
        i+=sum;
        if(i==s.length())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        String S = "DGHIKIKNM" ,
        T = "D5K1" ;
        System.out.println(checkCompressed(S,T));
    }
}
