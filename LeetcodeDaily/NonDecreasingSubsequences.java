//https://leetcode.com/problems/non-decreasing-subsequences/description/

import java.util.*;

public class NonDecreasingSubsequences {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        findSub(0,nums);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }

    List<List<Integer>> findSub(int i , int [] nums){
        List<List<Integer>> r = new ArrayList<>();
        if(i == nums.length -1){
            List<Integer> a = new ArrayList<>();
            a.add(nums[i]);
            r.add(new ArrayList<>(a));
            return r;
        }
        for (int j = i; j < nums.length; j++) {
            if(j == i){
                List<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                r.add(new ArrayList<>(a));
            }
            else
            {
                if(nums[i] <= nums[j]){
                    List<List<Integer>> sub = findSub( j , nums);
                    for (List<Integer> s:sub ) {
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.addAll(s);
                        r.add(new ArrayList<>(a));
                    }
                }
                else findSub(j , nums);
            }
        }
        for ( List<Integer> lst:r  )    if(lst.size() >= 2) res.add(lst);
        return r;
    }

    public static void main(String[] args) {
        NonDecreasingSubsequences sol =new NonDecreasingSubsequences();
        int arr[] = {4,6,7,7};
        System.out.println(sol.findSubsequences(arr));
    }
}
