//https://leetcode.com/problems/expression-add-operators/

import java.util.*;

public class ExpressionAddOperators {

    StringBuilder str = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        addOperators(num, target, 0, 0, 0);
        return res;
    }

    void addOperators(String num, long target, int posi, long currnum, long prev) {
        // System.out.println(str +" "+ currnum);

        if (posi == num.length()) {
            if (currnum == target && !res.contains(str.toString())) {
                res.add(str.toString());
            }
            return;
        }
        
        for (int i = posi; i < num.length(); i++) {
            if(i != posi && num.charAt((int) posi) == '0') break;

            long  numI = Long.parseLong(num.substring(posi, i + 1));
            StringBuilder now = new StringBuilder(str);
            
            // mulOpp
            if(posi!=0)
            str.append("*"+numI);
            else{
            str.append(numI);
            }
            if (posi != 0)
                addOperators(num, target, i + 1, (currnum - prev) + (prev * numI) , prev * numI);
            else {
                addOperators(num, target, i + 1, numI , numI);
            }
            str = new StringBuilder(now);

            // addOpp
            if(posi!=0)
            str.append("+"+numI);
            else{
            str.append(numI);
            }
            addOperators(num, target, i +1, currnum + numI , numI);
            str = new StringBuilder(now);

            // SubOpp
            if(posi!=0)
            str.append("-"+numI);
            else{
            str.append(numI);
            }
            if (posi != 0)
                addOperators(num, target, i + 1, currnum - numI ,-numI );
            else {
                addOperators(num, target, i + 1, numI , numI);
            }
            str = new StringBuilder(now);
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators sol = new ExpressionAddOperators();
        List<String> opp = sol.addOperators("9999999999", 1409865409);
        System.out.println(opp);
        
    }
}
