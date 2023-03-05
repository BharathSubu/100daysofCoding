//https://practice.geeksforgeeks.org/problems/a6528c893d4ab645ec6e0690c7982748385099c8/1
import java.util.*;
public class UpdateQueries {
    int [] updateQuery(int N, int Q, int [][]U){
        int result[] = new int[N];

        for(int k=0;k<Q;k++){
            int l = U[k][0];
            int r = U[k][1];
            int x = U[k][2];
            for(int i=l-1;i<r;i++){
                result[i] = result[i] | x ;
            }
        }
        return result;
    }
}
