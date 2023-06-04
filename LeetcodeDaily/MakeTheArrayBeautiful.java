//https://practice.geeksforgeeks.org/problems/badefd58bace4f2ca25267ccfe0c9dc844415e90/1
import java.util.*;

public class MakeTheArrayBeautiful {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(st.isEmpty() || st.peek() < 0 && arr[i] < 0 || st.peek() >= 0 && arr[i] >= 0) st.push(arr[i]);
            else st.pop();
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!st.empty()){
            res.add(st.pop());
        }
        Collections.reverse(res);
        return res;
    }
}
