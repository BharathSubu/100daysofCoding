//https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/submissions/

public class MinimumFlipsToMakeAOrBEqualToC {
    public  int minFlips(int a, int b, int c) {
        int result = 0;
        for(int  i = 0 ; i<32 ; i++){
            boolean x = false , y = false , z = false;
            if((a&(1<<i)) != 0) x=true;
            if((b&(1<<i)) != 0) y=true;
            if((c&(1<<i)) != 0) z=true;
            if(z == false){
                if( x == y && x == true){
                    result+=2;
                }
                else if(x == true || y == true) result++;
            }
            if(z == true){
                if( x == y && x == false){
                    result+=1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumFlipsToMakeAOrBEqualToC sol = new MinimumFlipsToMakeAOrBEqualToC();
        System.out.println(sol.minFlips(12,4,19));
    }
}
