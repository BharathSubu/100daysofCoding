//https://leetcode.com/problems/maximum-69-number/submissions/838786243/
public class Maximum69Number {
    public int maximum69Number (int num) {

        int n = num;
        int posi = -1;
        int i = 0;
        while(n!=0){
            int rem = n%10;
            if(rem == 6){
                posi = i;
            }
            i++;
            n/=10;
        }
        if(posi == -1) return num;
        else{
            num+= 3 * Math.pow(10,posi);
        }

        return num;
    }
}
