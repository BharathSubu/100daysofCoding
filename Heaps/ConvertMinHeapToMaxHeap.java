//https://practice.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=convert-min-heap-to-max-heap
public class ConvertMinHeapToMaxHeap {
    static void convertMinToMaxHeap(int N, int arr[]) {
        for(int i = N-1 ; i >= 0 ; i--)
            MinHeapify(i,arr,N);
    }

    static void MinHeapify(int i , int harr[],int heap_size) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] > harr[i]) smallest = l;
        if (r < heap_size && harr[r] > harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest, harr,heap_size);
        }
    }
    static int parent(int i) { return (i - 1) / 2; }
    static int left(int i) { return (2 * i + 1); }
    static int right(int i) { return (2 * i + 2); }

    public static void main(String[] args) {
        int N = 5;
        int []arr = {3, 4, 8, 11, 13};
        convertMinToMaxHeap(N,arr);
    }
}
