//https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall2042
public class FloydWarshall {
    public void shortest_distance(int[][] matrix)
    {
        // Already the adj matrix is  given
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) matrix[i][j] = Integer.MAX_VALUE/2;
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == Integer.MAX_VALUE/2) matrix[i][j] = -1 ;
            }
        }

        //detect for negative cycle
        for (int i = 0; i < n; i++) {
            if(matrix[i][i]<0) {
                System.out.println("Has Negative Cycle");
            }
        }
    }
}
