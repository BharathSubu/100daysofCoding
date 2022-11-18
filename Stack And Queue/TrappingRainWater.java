// https://leetcode.com/problems/trapping-rain-water/

import java.util.*;



class TrappingRainWater{
    public int trap(int[] height) {
        int result  = 0;
        Stack<Pair> st = new Stack<>();
        for(int i = 0 ; i < height.length ; i++){
            if(st.empty()){
                st.push(new Pair(height[i], i));
            }
            else{
                if(st.peek().first >= height[i]){
                    if(st.peek().first == height[i]){
                        st.pop();
                    }
                    st.push(new Pair(height[i], i));
                }
                else{
                    while(st.size()!=0 && height[i]>st.peek().first)
                    {
                    Pair pr = st.pop();
                    if(st.size() == 0){
                            st.push(new Pair(height[i], i));
                            continue;
                    }
                    int h = Math.min(st.peek().first, height[i]) - pr.first;
                    int d = i - st.peek().second - 1;
                    result+= (h*d);
                    
                    }
                    st.push(new Pair(height[i], i));
                    
                }
            }
            
        }
        return result;
    }
    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();
        int [] height = {4,2,0,3,2,5};
        System.out.println(sol.trap(height));
    }

}