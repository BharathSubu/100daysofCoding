//https://practice.geeksforgeeks.org/problems/546ea68f97be7283a04ddcc8057e09b46a686471/1
import java.util.*;

public class RemoveTheBalls {
    public static int finLength(int n, int[] color, int[] radius) {
        Stack<Pair> st = new Stack<>();
        for(int i = 0;i<n;i++){
            if(!st.isEmpty() && (st.peek().first == color[i] && st.peek().second == radius[i]))
                while(!st.isEmpty() && (st.peek().first == color[i] && st.peek().second == radius[i])) st.pop();
            else st.push(new Pair(color[i],radius[i]));
        }
        return st.size();
    }

}
class Pair{
    int first , second;
    Pair(int f , int s){
        first = f; second = s;
    }
}
