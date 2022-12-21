//https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=fractional-knapsack

import java.util.Arrays;
import java.util.PriorityQueue;
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class KnapSack {
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n)
    {
        double a[][]=new double[n][2];
        for(int i=0;i<n;i++)
        {
            a[i][0]=arr[i].value;
            a[i][1]=arr[i].weight;
        }
        Arrays.sort(a, (x, y) -> Double.compare(x[0]/x[1], y[0]/y[1]));
        double ans=0;
        for(int i=n-1;i>=0;i--)
        {
            if(w>=a[i][1])
            {
                ans+=a[i][0];
                w-=a[i][1];
            }
            else
            {
                ans+=((double)a[i][0]/(double)a[i][1])*w;
                break;
            }
        }
        return ans;
    }
}

class KPair{
    int idx;
    double pw;
    KPair(int a , double b){
        idx = a;
        pw = b;
    }
}
