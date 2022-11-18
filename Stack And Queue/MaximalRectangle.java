//https://leetcode.com/problems/maximal-rectangle/

import java.util.*;

public class MaximalRectangle {
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

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int arr[] = new int[col];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            arr[i] = 0;
        }
        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '0'){
                    mat[i][j] = 0;
                }
                else {
                    mat[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <row; i++) {
            for (int j = 0; j <col; j++) {
                if(mat[i-1][j] != 0 && mat[i][j]!= 0) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < row; i++) {
            max = Math.max(max,largestRectangleArea(mat[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();
        char[][] matrix =  {{'1'},{'1'}};
        System.out.println(sol.maximalRectangle(matrix));
    }
}
