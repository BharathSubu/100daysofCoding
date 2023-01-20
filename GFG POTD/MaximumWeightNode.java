//https://practice.geeksforgeeks.org/problems/b64485d3994958cca8748991bb58668204b3e4c0/1

import java.util.*;

public class MaximumWeightNode {

    public int maxWeightCell(int n, int edge[]){

        int ans=0;
        int maxi=0;
        int degree[] = new int[n];
        Arrays.fill(degree,0);
        for(int i=0;i<n;i++)
        {
            int to=edge[i];
            if(to!=-1)
            {
                degree[to]+=i;
                if(maxi<=degree[to])
                {
                    maxi=degree[to];
                    ans=to;
                }
            }
        }
        return ans;
    }



}
