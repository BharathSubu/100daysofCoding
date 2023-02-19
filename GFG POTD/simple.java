import java.util.*;
public class simple {
    public static void main(String[] args) {
        int n = 5;
        int mat[][] = new int[n][n];
        Arrays.stream(mat).forEach(a->Arrays.fill(a,-1));
        for (int i = 0; i < n; i++) {
            boolean iszero = false;
            for (int j = 0; j < n; j++) {

                if(i==j||i+j==n-1){
                    mat[i][j]=0;
                    iszero=!iszero;

                }
                if(i==j && i+j==n-1){
                    iszero=!iszero;
                }
                System.out.println(iszero);
                if(mat[i][j]!=0){
                    if (!iszero) {
                        mat[i][j] = 1;
                    }
                    if (iszero) {
                        mat[i][j] = 2;
                    }
                }
                System.out.println(mat[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
}
