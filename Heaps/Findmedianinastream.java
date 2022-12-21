// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-median-in-a-stream

import java.util.*;

class Findmedianinastream
{
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max  = new PriorityQueue<>((first,second)->second-first);
    static int count = 0;
    
    public static void insertHeap(int x)
    {
        count++;
        if(max.size() == 0 || max.peek()>=x){
            max.add(x);
        }
        else {
            min.add(x);
        }
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
        if(min.size() == max.size()) return;
        if(count%2 == 1 && ((min.size() -1 == max.size())||(min.size() == max.size() - 1))) return;
        if(min.size() > max.size()){
            max.add(min.poll()); 
        }
        else{
            min.add(max.poll());
        }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(count%2==0) {
            double res = min.peek() + max.peek();
            return res/2;
        }
        else {
            double res = min.size() > max.size() ? min.peek() : max.peek() ;
            return res;
        }
    }
}