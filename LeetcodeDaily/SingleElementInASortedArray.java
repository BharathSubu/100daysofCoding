//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start =  0 , end = nums.length -1;
        if(end==0){return nums[0];}
        if(nums[end]!=nums[end-1]){return nums[end];}
        if(nums[0]!=nums[1]){return nums[0];}
        while (start <= end){
            int mid = (start+end)/2;
            int e =nums[mid];
            if(nums[mid+1]!=e && nums[mid-1]!=e){return e;}
            else{
                if((mid%2!=0&& nums[mid-1]==nums[mid])||(mid%2==0&&nums[mid+1]==nums[mid])){start=mid+1;}
                else{end=mid-1;}
            }
        }
        return -1;
    }
}
