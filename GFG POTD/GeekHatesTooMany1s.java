//https://practice.geeksforgeeks.org/problems/07e45fe40846bc670ad2507d2c649304699768b9/1
public class GeekHatesTooMany1s {
    public static int noConseBits(int n) {
        int set[] = new int[32];
        for(int i = 0 ; i < 32 ;i++){
            if((n&(1<<31-i))!=0) set[i] = 1;

        }
        int ans = 0;
        for(int i = 0;i<=29;i++)
        {
            if(set[i] == 1){
                ans+=(1<<(31-i));
                if(set[i+1] == 1){
                    set[i+2] = 0;
                }
            }
        }
        if(set[30]==1) ans+=2;
        if(set[31]==1) ans+=1;
        return ans;
    }
}
