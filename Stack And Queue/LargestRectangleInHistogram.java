// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.*;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int leftsmaller[] = new int[heights.length];
        int rightsmaller[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (!st.empty())
                leftsmaller[i] = st.peek() + 1;
            else
                leftsmaller[i] = 0;
            st.push(i);

        }

        st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.empty() && heights[i] <= heights[st.peek()]) {
               st.pop();
            }
           
            if (!st.empty())
                rightsmaller[i] = st.peek() - 1;
            else
                rightsmaller[i] = heights.length -1;
            st.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i]*(1+rightsmaller[i]-leftsmaller[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
        int[] height = { 2, 1, 5, 6, 2, 3, 1 };
        System.out.println(sol.largestRectangleArea(height));
    }
}