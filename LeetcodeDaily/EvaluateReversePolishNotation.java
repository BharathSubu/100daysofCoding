//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        List<Character> oop = new ArrayList<>(Arrays.asList('^','*','/','%','-','+','(',')'));
        List<String> res =new ArrayList<>();
        for (String s :  tokens) {
            res.add(s);
        }
        int n = res.size();
        int k = 0;
        int sol = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            char now = 'n';
            if(res.get(k).length() == 1)
                now = res.get(k).charAt(0);
            if(oop.contains(now)){
                if(now == '+'){
                    int a = Integer.parseInt(res.get(k-2)) ;
                    int b = Integer.parseInt(res.get(k-1));
                    num  =a+b;

                }
                else if(now == '-'){
                    int a = Integer.parseInt(res.get(k-2)) ;
                    int b = Integer.parseInt(res.get(k-1));
                    num  =a-b;

                }
                else if(now == '*'){
                    int a = Integer.parseInt(res.get(k-2)) ;
                    int b = Integer.parseInt(res.get(k-1));
                    num   =a*b;

                }
                else if(now == '/'){
                    int a = Integer.parseInt(res.get(k-2)) ;
                    int b = Integer.parseInt(res.get(k-1));
                    num  =a/b;
                }
                res.remove(k);
                res.remove(k-1);
                res.set(k-2 , Integer.toString(num));
                k = k - 1;
            }
            else{
                k++;
            }

        }
        return Integer.parseInt(res.get(0).toString());
    }
}
