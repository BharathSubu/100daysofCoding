public class EvenSwap {
    int [] lexicographicallyLargest(int [] arr, int n) {
        while(true){
            int cnt=0;
            for(int i=0;i<n-1;i++)
            {
                if((arr[i]+arr[i+1])%2==0 && arr[i+1]>arr[i])
                {
                    cnt++;
                    swap(arr,i,i+1);
                }
            }
            if(cnt==0)
                break;
        }
        return arr;
    }
    public void swap(int[] arr,int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    }
