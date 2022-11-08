//https://leetcode.com/problems/next-greater-element-ii/submissions/839571417/
import java.util.*;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length ;

        int [] arr = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n*2 - 1 ; i >= 0 ; i--) {
            if(st.size() == 0){
                arr[i%n] = -1;
                st.push(nums[i%n]);
            }
            else if(nums[i%n] < st.peek()){
                arr[i%n] = st.peek();
                st.push(nums[i%n]);
            }
            else{
                while(st.size() !=0 && nums[i%n] >= st.peek() ){
                    st.pop();
                }
                if(st.size() != 0)
                    arr[i%n] = st.peek();
                else arr[i%n] = -1;
                st.push(nums[i%n]);
            }

        }
        return arr;
    }
    public static void main(String[] args) {

        int [] nums = {5,4,3,2,7,8,4};
        int arr[] =nextGreaterElements(nums);
        System.out.println(Arrays.toString(arr));
    }
}
