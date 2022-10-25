//https://leetcode.com/contest/weekly-contest-316/problems/minimum-number-of-operations-to-make-arrays-similar/

import java.util.*;


public class MinimumNoOfOperationToMakeArraysSimilar {

    public long makeSimilar(int[] nums, int[] target) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer>  oddtarget = new ArrayList<>();
        ArrayList<Integer>  even = new ArrayList<>();
        ArrayList<Integer>  eventarget = new ArrayList<>();

        long count = 0;

        for (int i = 0; i < target.length; i++) {
            if(nums[i]%2 == 0) even.add(nums[i]); 
            if(nums[i]%2 !=0 ) odd.add(nums[i]);
            if(target[i]%2 !=0 ) oddtarget.add(target[i]);
            if(target[i]%2 == 0 ) eventarget.add(target[i]);
        }
        
        Collections.sort(odd);
        
        Collections.sort(oddtarget);
        
        Collections.sort(even);
        
        Collections.sort(eventarget);

        
        for (int i = 0; i < odd.size(); i++) {
            // System.out.println(odd.get(i)+" "+oddtarget.get(i));
            count+=Math.abs(odd.get(i)-oddtarget.get(i));
        }
        
        for (int i = 0; i < even.size(); i++) {
            // System.out.println(even.get(i)+" "+eventarget.get(i));
            count+=Math.abs(even.get(i)-eventarget.get(i));
        }

        // System.out.println(count/4);

        return count/4;
    }

    

    public static void main(String[] args) {

        MinimumNoOfOperationToMakeArraysSimilar sol = new MinimumNoOfOperationToMakeArraysSimilar();
        int[] nums = {1,1,1,1,1};
        int[] target = {1,1,1,1,1};
        long result = sol.makeSimilar(nums, target);
        System.out.println(result);
    }
}