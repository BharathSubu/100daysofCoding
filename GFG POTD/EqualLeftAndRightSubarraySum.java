public class EqualLeftAndRightSubarraySum {
    int equalSum(int [] A, int N) {
        if(N==1){
            return N;
        }
        int sum =0;
        for(int i=0;i<N;i++){
            sum+=A[i];
        }
        int curr=0;
        int ans=0;
        for(int i=0;i<N-1;i++){
            curr+=A[i];
            sum-=A[i];
            if(sum-A[i+1]==curr){
                ans = i+2;
                break;
            }
        }
        if(ans==0){
            return -1;
        }
        else{
            return ans;
        }
    }
}
