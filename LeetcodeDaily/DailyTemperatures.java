// https://leetcode.com/problems/daily-temperatures/

import java.util.*;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int n = temperatures.length;
        for (int i = n-1; i >=  0; i--) {
            if(st.empty() || st.peek().first > temperatures[i]){
                int currtemp = temperatures[i];
                if(!st.empty())
                temperatures[i] = st.peek().second - i;
                else temperatures[i] = 0;
                st.add(new Pair(currtemp, i));
            }
            else{
                while(!st.empty() && st.peek().first <= temperatures[i]){
                    st.pop();
                }
                int currtemp = temperatures[i];
                if(!st.empty())
                temperatures[i] = st.peek().second - i;
                else temperatures[i] = 0;
                st.add(new Pair(currtemp, i));
            }            
        }
        return temperatures;
    }
}
class Pair{
    int first;
    int second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}