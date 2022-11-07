//https://leetcode.com/problems/basic-calculator-ii/

import java.util.*;


public class BasicCalculator {

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static List<String> infixToPostfix(String exp) {

        List<String> result = new ArrayList<>();
        Stack < Character > stack = new Stack < > ();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if(exp.charAt(i) == '-' && (i-1 == -1 || (exp.charAt(i-1) == '(' && exp.charAt(i+1) >= '0'  && exp.charAt(i+1)<='9'))) {
                int start = i+1;
                int end = i + 2;
                while (end < exp.length() && exp.charAt(end) >= '0' && exp.charAt(end) <= '9') {
                    end++;
                }
                result.add("-"+exp.substring(start, end));
                i = end - 1;
            }
            else if( exp.charAt(i) >= '0'  && exp.charAt(i)<='9') {
                int start = i;
                int end = i + 1;
                while (end < exp.length() && exp.charAt(end) >= '0' && exp.charAt(end) <= '9') {
                    end++;
                }
                result.add(exp.substring(start, end));
                i = end - 1;
            }
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result.add(stack.pop().toString()) ;

                stack.pop();
            } else
            {
                while (!stack.isEmpty() && Prec(c) <=
                        Prec(stack.peek())) {

                    result.add(stack.pop().toString());
                }
                stack.push(c);
            }
            System.out.println(result);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().toString());
        }
        return result;
    }

    public int calculate(String exp) {
        List<Character> oop = new ArrayList<>(Arrays.asList('^','*','/','%','-','+','(',')'));
        Stack<Character> st = new Stack<>();
        exp = exp.replaceAll("\\s+","");
        List<String> res = infixToPostfix(exp);
       System.out.println(res);
        int n = res.size();
        int k = 0;
        int sol = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            char now = '~';
            if(res.get(k).length() == 1 )
            {
                now = res.get(k).charAt(0);
            }

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


    public static void main(String[] args) {
        BasicCalculator sol = new BasicCalculator();
        String s = "1-(     -2)";
        int result = sol.calculate(s);
        System.out.println(result);
    }
}