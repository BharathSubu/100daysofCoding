//https://practice.geeksforgeeks.org/problems/d385b9d635b7b10eef6bf365b84922aaeec9eb98/1
import java.util.*;
public class StringMirror {
    public static String stringMirror(String str) {
        char curr = str.charAt(0);
        int i = 1;
        if(i < str.length() && str.charAt(i) != str.charAt(i-1))
            while(i < str.length()){
                if(curr >= str.charAt(i)) {
                    curr = str.charAt(i++);
                }
                else break;
            }
        String reverse = new StringBuilder(str.substring(0,i)).reverse().toString();
        String res = str.substring(0,i)+ reverse;
        return res;
    }
}
