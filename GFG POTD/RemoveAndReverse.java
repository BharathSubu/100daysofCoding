//https://practice.geeksforgeeks.org/problems/1e2f365be6114b671b915e145ec7dbcfdc432910/1
import java.util.*;
public class RemoveAndReverse {
    String removeReverse(String S)
    {
        int i=0,j=S.length()-1;

        int[] map=new int[26]; Arrays.fill(map,0);
        boolean flag=true;
        int cnt=0;


        for(char ch:S.toCharArray()) map[ch-'a']++;

        String begin="",end="";

        while(i<=j)
        {
            char ch;
            if(flag) ch=S.charAt(i++);
            else ch=S.charAt(j--);

            if(map[ch-'a']>1)
            {
                map[ch-'a']--;
                cnt++;
                flag=!flag;
            }
            else
            {
                if(flag) begin+=ch;
                else end=ch+end;
            }
        }

        StringBuffer ans=new StringBuffer(begin+end);

        if(cnt%2==1) ans.reverse();

        return ans.toString();
    }
}
