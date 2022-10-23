//https://leetcode.com/problems/combination-sum-ii/

import java.util.*;

public class CombinationSumII {

    List<List<Integer>> res = new ArrayList<>();
    int currsum = 0;
    List<Integer> nums = new ArrayList<Integer>();
    List<Integer> arr = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = Arrays.stream(candidates).boxed().toList();
        nums = list;
        combinationSum2(target, 0);
        return res;
    }

    void combinationSum2(int target, int curri) {
        if (currsum > target) {
            return;
        }
        if (currsum == target && !res.contains(arr)) {
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
            combinationSum2(target, j + 1);
            arr.remove(arr.size() - 1);
            currsum -= num;
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        CombinationSumII sol = new CombinationSumII();
        List<List<Integer>> res = sol.combinationSum2(candidates, target);
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
