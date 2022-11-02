import java.util.ArrayList;
import java.util.Collections;

//https://leetcode.com/problems/single-number-ii/
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        ArrayList<Integer> f = new ArrayList<>(Collections.nCopies(32, 0));

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if((num & (1<<i)) != 0){
                    f.set(i,f.get(i)+1);
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            if(f.get(i)%3 == 1){
               result+=(1<<i);
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        SingleNumberII sol = new SingleNumberII();
        int [] arr = { 1,1,1,2,2,2,3,3,3,4};
        System.out.println(sol.singleNumber(arr));
    }
}
