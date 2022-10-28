//https://leetcode.com/problems/single-number/

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int i = 1;
        int number = nums[0];
        while(i!=n){
            number = number ^ nums[i];
            i++;
        }
        return number;
    }

    public static void main(String[] args) {
        int [ ] nums = {4,1,1,2,2};
        System.out.println(singleNumber(nums));
    }
}
