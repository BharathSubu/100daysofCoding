//https://leetcode.com/problems/search-a-2d-matrix-ii/

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int currrow = 0 , currcol = col -1;
        while(currcol >= 0 && currrow < row ){
            if(matrix[currrow][currcol] == target) return true;
            if(matrix[currrow][currcol] > target) currcol--;
            else currrow++;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] =  {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        SearchA2DMatrixII sol = new SearchA2DMatrixII();
        System.out.println(sol.searchMatrix(arr,20));
    }
}
