//https://leetcode.com/problems/basic-calculator-ii/

import java.util.*;


public class BasicCalculatorII {

    public int calculate(String exp) {
        List<Character> oop = new ArrayList<>(Arrays.asList('^','*','/','%','-','+','(',')'));
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char now = exp.charAt(i);
            if(oop.contains(now)){
                char top = ' ';
                if(st.size() != 0){
                    top = st.peek();
                }
                if(st.size() == 0){
                    st.push(now);
                } else if (now == '(') {
                    st.push('(');
                } else if (now == ')') {
                    while(st.peek() != '('){
                        res.append(st.pop());
                    }
                    st.pop();
                } else if ((now =='-' && st.peek() == '+') || (now =='*' && st.peek() == '/') || oop.indexOf(now) >= oop.indexOf(st.peek()) ) {
                    while (st.peek() != '(' && st.size() != 1){
                        res.append(st.pop());
                    }
                    if(st.peek() != '(')
                        res.append(st.pop());
                    st.push(now);
                } else{
                    st.push(now);
                }
            }
            else {
                res.append(now);
            }
//            System.out.println(Arrays.toString(st.toArray()));
        }
        while ( st.size() != 0){
            res.append(st.pop());
        }
        System.out.println(res);
        int n = res.length();
        int k = 0;
        int sol = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            char now = res.charAt(k);
            if(oop.contains(now)){

                if(now == '+'){
                     int a =  res.charAt(k-2) - '0';
                     int b =  res.charAt(k-1)- '0';
                      num  =a+b;
                     sol+=num;
                     res.replace(k-2,k+1,Integer.toString(num));
                 }
                else if(now == '-'){
                    int a =  res.charAt(k-2) - '0';
                    int b =  res.charAt(k-1)- '0';
                     num  =a-b;
                    sol+=num;
                    res.replace(k-2,k+1,Integer.toString(num));
                }
                else if(now == '*'){
                    int a =  res.charAt(k-2) - '0';
                    int b =  res.charAt(k-1)- '0';
                    num   =a*b;
                    sol+=num;
                    res.replace(k-2,k+1,Integer.toString(num));
                }
                else if(now == '/'){
                    int a =  res.charAt(k-2) - '0';
                    int b =  res.charAt(k-1)- '0';
                     num  =a/b;
                    sol+=num;
                    res.replace(k-2,k+1,Integer.toString(num));
                }
                k = k - 1;
            }
            else{
                k++;
            }
//            System.out.println(res+" "+num);
        }
        return Integer.parseInt(res.toString());
    }

    public static void main(String[] args) {

        BasicCalculatorII sol = new BasicCalculatorII();
        String s = "3+5/2";
        int result = sol.calculate(s);
        System.out.println(result);
    }
}