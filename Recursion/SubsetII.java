// https://leetcode.com/problems/subsets-ii/
import java.util.*;

public class SubsetII {
    List<List<Integer>> res = new ArrayList<>();
    int currsum = 0;
    List<Integer> nums = new ArrayList<Integer>();
    List<Integer> arr = new ArrayList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] array) {
        Arrays.sort(array);
        List<Integer> list = Arrays.stream(array).boxed().toList();
        nums = list;
        subsetsWithDup(0);
        return res;
    }

    void subsetsWithDup(int curri) {
        res.add(new ArrayList<>(arr));
        if (curri == nums.size()) {

            return;
        }

        for (int j = curri; j < nums.size(); j++) {
            if (j > curri && nums.get(j) == nums.get(j - 1))
                continue;
            int num = nums.get(j);
            currsum += num;
            arr.add(num);
            subsetsWithDup(j + 1);
            arr.remove(arr.size() - 1);
            currsum -= num;
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 2 };

        SubsetII sol = new SubsetII();
        List<List<Integer>> res = sol.subsetsWithDup(array);
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
