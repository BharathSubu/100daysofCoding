//https://practice.geeksforgeeks.org/problems/51b266505221b97522b1d2c86ddad1868a54831b/1

public class WallsColoring {

        int minCost(int [][] colors, int n){

            for(int i = n-2 ; i >= 0 ; i--){
                colors[i][0]+=Math.min( colors[i+1][1], colors[i+1][2]);
                colors[i][2]+=Math.min( colors[i+1][1], colors[i+1][0]);
                colors[i][1]+=Math.min( colors[i+1][0], colors[i+1][2]);
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<3;i++){
                min = Math.min(colors[0][i],min);

            }
            return min;
        }

}
