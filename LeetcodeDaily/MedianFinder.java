import java.util.*;

// https://leetcode.com/problems/find-median-from-data-stream/submissions/841968594/

class MedianFinder {
    int size = 0;
    List<Integer> arr ;
    int median1 = -1;
    int median2 = -1;
    public MedianFinder() {
        arr =  new ArrayList<Integer>();
    }
    
    public void addNum(int num) {     
        if(arr.size()==0) {
            arr.add(num);
            return;
        } 
        for(int i = 0 ; i<arr.size() ;i++){
                if(arr.get(i) > num){
                    arr.add(i,num);
                    return;
                }
        }
        arr.add(num);
    }
    
    public double findMedian() {
        int i = arr.size()/2;
        if(arr.size() % 2 == 0){
            return (double) (arr.get(i) + arr.get(i - 1))/2;
        }else{
            return arr.get(i);
        }

    }
}

