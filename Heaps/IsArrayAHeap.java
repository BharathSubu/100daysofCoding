//https://practice.geeksforgeeks.org/problems/does-array-represent-heap4345/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=does-array-represent-heap
public class IsArrayAHeap {

    public boolean countSub(long arr[], long n)
    {
        for (int i = 0 ; i <n ; i++){
            if(!(left(i) >= n || arr[i] > arr[left(i)])){
                return false;
            }
            if(!(right(i) >= n || arr[i] > arr[right(i)])){
                return false;
            }
        }
        return true;
    }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }
}
