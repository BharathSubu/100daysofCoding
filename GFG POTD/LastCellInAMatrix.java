//https://practice.geeksforgeeks.org/problems/2e068e2342b9c9f40cfda1ed8e8119542d748fd8/1
public class LastCellInAMatrix {
    static int [] endPoints(int [][]matrix, int r, int c){
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int k = 1;
        int i = 0 , j =0;
        int curri = 0 , currj = 0;
        while(i >= 0 && i < r && j >= 0 && j < c){
            curri = i ; currj = j;
            if(matrix[i][j] == 0){
                i+=drow[k];
                j+=dcol[k];
            }
            else if(matrix[i][j] == 1){
                matrix[i][j] = 0;
                k = (k+1)%4;
                i+=drow[k];
                j+=dcol[k];
            }
        }
        int res[] = {curri , currj};
        return res;
    }
}
