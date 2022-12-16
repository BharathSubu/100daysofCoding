//https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=operations-on-binary-min-heap

class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    int extractMin(){
        if(heap_size== 0) return -1;
        else if(heap_size ==1){
            heap_size--;
            return harr[0];
        }
        else{
            int k= harr[0];
            harr[0]= harr[heap_size-1];
            harr[heap_size-1]=k;
            heap_size--;
            MinHeapify(0);
            return k;
        }
    }

    void insertKey(int k){
        if(heap_size<capacity){
            harr[heap_size]= k;
            int j=heap_size++;
            while(j>0 && harr[j] < harr[parent(j)] ){
                int r= harr[j];
                harr[j]= harr[parent(j)];
                harr[parent(j)]= r;
                j= parent(j);
            }
        }
    }
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }

    void deleteKey(int i) {
        if(i>=heap_size || heap_size== 0) return;
        if(i<=heap_size-1) decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }


    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */

}