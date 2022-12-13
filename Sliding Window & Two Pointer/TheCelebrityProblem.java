// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/

class TheCelebrityProblem
{ 
    int celebrity(int m[][], int n)
    {
    	int start = 0 , end = n-1;
        while(start<end){
            if(m[start][end] == 1){
                start++;
            }
            else{
                end--;
            }
        }
        int incount = 0;
        int outcount =  0;
        for (int i = 0; i < m.length; i++) {
            if(i!=start && m[i][start] == 1) incount++;
            if(m[start][i]==1) outcount++;
        }
        if(incount == n-1 && outcount == 0) return start;
        return -1;
        
    }
}