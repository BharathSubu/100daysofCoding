// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=job-sequencing-problem
import java.util.*;

class JobSequencing
{
    
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->b.profit - a.profit);
        int count = 0;
        int profit = 0;
        int isFree[] = new int[101];
        Arrays.fill(isFree, 1);
        for (Job job : arr) {
            int time = job.deadline;
            while(time > 0){
                if(isFree[time] == 1){
                    count++;
                    profit+=job.profit;
                    isFree[time] = 0;
                    break;
                }
                time--;
            }
        }
        int res[] = {count , profit};
        return res;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}