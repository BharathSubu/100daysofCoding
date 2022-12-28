//https://practice.geeksforgeeks.org/problems/shortest-job-first/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first
import java.util.*;
public class SJF {

    static int solve(int bt[] ) {
        Arrays.sort(bt);
        int res = 0 , t= 0;
        for (int i : bt  ) {
            res+=t;
            t+=i;
        }
        return res/bt.length;

    }
}
