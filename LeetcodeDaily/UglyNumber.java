// https://leetcode.com/problems/ugly-number/description/
public class UglyNumber {
    public boolean isUgly(int n) {
        int[]  num = {2,3,5};
        for (int i = 0; i < num.length; i++) {
            while(n%num[i] == 0){
                n=n/num[i];
            }
        }
        if(n==1) return true;
        return false;
    }
}
