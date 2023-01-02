import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-triangular-sum-of-an-array/description//

import java.util.*;

class TriangularSum {
    public int triangularSum(int[] nums) {
     List<Integer> lst = new ArrayList<>();
     Arrays.stream(nums).forEach(lst::add);
     while(lst.size() != 1){
        List<Integer> r = new  ArrayList<>();
        for (int i = 1; i < lst.size(); i++) {
            int ans = lst.get(i-1)+lst.get(i);
            r.add(ans%10);
        }
        lst = new ArrayList<>(r);
     }
     return lst.get(0);
    }
}