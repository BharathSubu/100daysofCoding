//https://leetcode.com/problems/combination-sum-iii/

import java.util.*;

public class CombinationSumIII {

    List<List<Integer>> res = new ArrayList<>();
    int currsum = 0;
    List<Integer> nums = new ArrayList<Integer>();
    List<Integer> arr = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        nums = list;
        combinationSum3(n, k, 0);
        return res;
    }

    void combinationSum3(int target, int k, int curri) {
        if (currsum > target) {
            return;
        }
        if (arr.size() > k)
            return;
        if (currsum == target && arr.size() == k) {
            res.add(new ArrayList<>(arr));
            return;
        }
        if (curri == nums.size())
            return;

        for (int j = curri; j < nums.size(); j++) {
            if (j > curri && nums.get(j) == nums.get(j - 1))
                continue;
            int num = nums.get(j);
            currsum += num;
            arr.add(num);
            combinationSum3(target, k, j + 1);
            arr.remove(arr.size() - 1);
            currsum -= num;
        }
    }

    public static void main(String[] args) {

        CombinationSumIII sol = new CombinationSumIII();
        List<List<Integer>> res = sol.combinationSum3(5, 18);
        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("End");
    }
}