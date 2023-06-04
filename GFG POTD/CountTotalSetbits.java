//https://practice.geeksforgeeks.org/problems/1132bd8ee92072cd31441858402641d6800fa6b3/1
import java.util.*;
public class CountTotalSetbits {
    public static long countBits(long n) {

        long count = 0;
        for (int x = 1; x <= n; x++){
            count+=getBits(x);
        }
        return count;
    }
    static long getBits(int x) {
        long count = 0;
        while (x!=0) {
            x &= x - 1;
            count++;
        }
        return count;
    }
}
