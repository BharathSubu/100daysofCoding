
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

    public static void main (String[] args) throws java.lang.Exception
    {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t!=0){
            int n ;
            String s;
            n = sc.nextInt();
            sc.nextLine();
            s=sc.next();
            StringBuilder s2 = new StringBuilder(s);
            s2 = new StringBuilder(s2.reverse());
//            System.out.println(s+" "+ s2);
            int id1 = s.length()- 1, id2 = s2.length() - 1;
            int dp[][] = new int[s.length()][s2.length()];
            Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
            int max = findLCM( s, s2.toString(),  id1,  id2 ,  dp);
            System.out.println(max/2);
            t--;
        }
    }

    private static int findLCM(String text1, String text2, int id1, int id2 , int[][] dp) {
        if(id1 < 0 || id2 < 0) return 0;
        if(dp[id1][id2] != -1) return dp[id1][id2];

        if(text1.charAt(id1)==(text2.charAt(id2))){
            dp[id1][id2] = 1 + findLCM(text1, text2, id1-1, id2-1, dp);
            return dp[id1][id2];
        }
        dp[id1][id2] = Math.max(findLCM(text1, text2, id1, id2-1, dp), findLCM(text1, text2, id1-1, id2, dp));
        return dp[id1][id2];
    }


}