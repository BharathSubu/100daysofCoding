//https://leetcode.com/problems/sort-an-array/
import java.util.*;
public class SortAnArray {
    void merge(int nums[],int start,int mid , int end){
        int i = start;
        int j = mid+1;
        int arr[] = new int[end-start+1];
        int k = 0;
        while(i!=mid+1 && j!=end+1){
            if(nums[i]<nums[j]){
                arr[k++] = nums[i];
                i++;
            }
            else{
                arr[k++] = nums[j];
                j++;
            }
        }
        while(i!=mid+1){
            arr[k++] = nums[i++];
        }
        while(j!=end+1){
            arr[k++] = nums[j++];
        }
        int x = 0;
        while(x!=k){
            nums[start++] = arr[x++];
        }
    }

    void mergesort(int [] nums , int start , int end){
        int mid = (start+end)/2;
        if(start!=end){
            mergesort(nums,start,mid);
            mergesort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length - 1);
        return nums;
    }
}
