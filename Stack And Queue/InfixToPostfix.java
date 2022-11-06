//https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=infix-to-postfix
import java.util.*;


public class InfixToPostfix {

    public static String infixToPostfix(String exp) {
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
            System.out.println(Arrays.toString(st.toArray()));
        }
        while ( st.size() != 0){
            res.append(st.pop());
        }
        return res.toString();
    }

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

    static String infixToPostfix2(String exp) {
        // initializing empty String for result
        String result = new String("");
        // initializing empty stack
        Stack < Character > stack = new Stack < > ();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);
                // If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <=
                        Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println( infixToPostfix("(a*b)-(c*d)+(e/f)"));;
    }

}
