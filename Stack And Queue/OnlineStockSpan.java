//https://leetcode.com/problems/online-stock-span/submissions/839829193/
import java.util.*;

public class OnlineStockSpan {
    class  Pair{
        int first;
        int second;
        Pair(int a, int b){
            first = a;
            second = b;
        }
    }
    Stack<Pair> st = new Stack<>();

    public OnlineStockSpan() {

    }

    public int next(int price) {
        int days =1;
        while(st.size()!=0 && st.peek().first < price){
            days+=st.pop().second;
        }
        st.push(new Pair(price,days));
        return st.peek().second;
    }
}
