//https://leetcode.com/problems/basic-calculator-ii/

import java.util.*;


public class BasicCalculatorII {

    public int calculate(String s) {
        s = s.replaceAll("\\s+","");
        System.out.println(s);
        int start = 0;
        int end = 0;
        int result = 0;
        char ch = '=';
        int nowresult = 0;
        int prev = 0;
        for (int i = 1; i < s.length(); i++) {

            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9') || i == s.length()-1){
                if(i==s.length()-1) end = i+1;
                else end = i;
                int number = Integer.parseInt(s.substring(start, end));
                start = i + 1;
                System.out.println(number+" "+result);
            }
        }
        return nowresult;
    }

    public static void main(String[] args) {

        BasicCalculatorII sol = new BasicCalculatorII();
        String s = "324-234*234/34/4/2/3*3";
        int result = sol.calculate(s);
        System.out.println(result);
    }
}