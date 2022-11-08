
//https://leetcode.com/problems/next-greater-element-i/

import java.util.*;

public class NextGreaterElementI {
    public  static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] arr = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1 ; i >= 0 ; i--) {
            if(st.size() == 0){
                map.put(nums2[i],-1);
                st.push(nums2[i]);
            }
            else if(nums2[i] < st.peek()){
                map.put(nums2[i],st.peek());
                st.push(nums2[i]);
            }
            else{
                while(st.size() !=0 && nums2[i] > st.peek() ){
                    st.pop();
                }
                if(st.size() != 0)
                map.put(nums2[i],st.peek());
                else map.put(nums2[i] , -1);
                st.push(nums2[i]);
            }
            System.out.println(nums2[i] +" "+map.get(nums2[i]));
        }
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }
}
