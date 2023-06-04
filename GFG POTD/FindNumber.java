//https://practice.geeksforgeeks.org/problems/35bff0ee40090b092e97b02f649085bf1390cc67/1
import java.util.*;
public class FindNumber {
    public long findNumber(long N)
    {
        int[] arr= { 9 , 1 , 3 , 5 , 7 };
        long curr=1, ans=0;
        while(N!=0)
        {
            long index= N%5;
            ans = arr[(int)index] * curr + ans;
            if(N%5==0) N = N/5 - 1;
            else N = N/5;
            curr *=10;
        }
        return ans;
    }
}
