//https://practice.geeksforgeeks.org/problems/aa8c89caad6b5c3a76ba5e6d65454f77aac3f3543526/1
import java.util.*;
public class RemainderOnDividingBy11 {
    static int xmod11(String x)
    {
        int odd = 0, even = 0;
        for(int i = 0; i < x.length(); ++i) {
            if(i % 2 == 0)
                odd += (x.charAt(i) - '0');
            else
                even += (x.charAt(i) - '0');
        }


        int diff = (odd - even) % 11;

        if(x.length() % 2 == 0)
            return Math.abs(diff - 11) % 11;

        if(diff < 0)
            return 11 + diff;
        return diff;

    }
}
