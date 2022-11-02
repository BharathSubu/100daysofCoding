//https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> per = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            per.add(nums[i]);
        }
        permute(nums,0);
        return result;
    }

    void permute(int[] nums , int posi){
        if(posi == nums.length - 1){
            List<Integer> sol = new ArrayList<>(per);
            result.add(sol);
        }
        for(int i = posi ; i < nums.length ; i++){
            int temp1 = per.get(i);
            int temp2 = per.get(posi);
            per.set(posi , temp1);
            per.set(i,temp2);
            permute(nums,posi+1);
            per.set(posi , temp2);
            per.set(i,temp1);
        }
    }

    public static void main(String[] args) {
        Permutation sol = new Permutation();
        int arr[ ] = {1,2,3};
        System.out.println(sol.permute(arr));
    }
}
