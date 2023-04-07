//https://practice.geeksforgeeks.org/problems/55dbfdc246f3f62d6a7bcee7664cacf6be345527/1
import java.util.*;
public class AddMinimumCharacters {
    public static int addMinChar(String str){
        int n = str.length();
        int i = 0 , j = n-1; int trim = j , res = 0;
        while(i<j){
            if(str.charAt(i) == str.charAt(j)){
                i++;j--;
            }
            else {
                res++;
                i = 0;
                j= --trim;
            }
        }
        return res;
    }
}
