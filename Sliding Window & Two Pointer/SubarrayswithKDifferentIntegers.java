
//https://leetcode.com/problems/subarrays-with-k-different-integers/

import java.util.*;

public class SubarrayswithKDifferentIntegers {

    long atmost(int[] s, int k)
    {
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = s.length;
        int j = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {


            m.put(s[i],m.getOrDefault(s[i],0)+1);
            while (m.size() > k)
            {
                m.put(s[j],m.get(s[j])-1);
                if (m.get(s[j]) == 0)
                    m.remove(s[j]);
                j++;
            }
            count += (i - j + 1);
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return (int) (atmost(nums, k) - atmost(nums, k - 1));
    }
}
