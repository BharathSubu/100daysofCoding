//https://practice.geeksforgeeks.org/problems/swap-two-numbers3844/1
import java.util.*;

public class SwapTwoNumber {
    static List<Integer> get(int a,int b)
    {
        a^=b;
        b^=a;
        a^=b;
        List<Integer> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        return arr;
    }
}
