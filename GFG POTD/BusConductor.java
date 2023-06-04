//https://practice.geeksforgeeks.org/problems/c6ced401352fd126b89129cd562a9247f057e40e/1
import java.util.*;
public class BusConductor {
    public static int findMoves(int n, int[] ch, int[] pa) {
        Arrays.sort(ch);
        Arrays.sort(pa);
        int ans = 0;
        for(int i=0;i<ch.length;i++){
            while(ch[i]!=pa[i]){
                if(ch[i]<pa[i]) pa[i]--;
                else pa[i]++;
                ans++;
            }
        }
        return ans;
    }
}
