import java.util.Arrays;

// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
class LimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < queries.length; i++) {
            nums[i] += nums[i-1];
        }
        int arr[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
           if(nums[0] > queries[i]) arr[i] = 0;
           else if(nums[nums.length-1] < queries[i]) arr[i] = nums.length;
           else{
              arr[i] = 1 + search(nums, queries[i]);
           }
        }
        return arr;
    }
    int search(int[] nums, int query){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start+end)/2;
            if(nums[mid] == query) return mid;
            if(mid - 1 >= 0 && (nums[mid -1] < query && nums[mid] > query )) return mid-1;
            if(mid + 1 <= nums.length -1 && (nums[mid +1] > query && nums[mid] < query )) return mid;
            if(nums[mid] < query) start = mid + 1;
            else end = mid - 1;
        }
        return mid;
    }
}