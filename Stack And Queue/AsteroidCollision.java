import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/

class AsteroidCollision {
    public int[] asteroidCollision(int[] arr) { 
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if ( st.empty() || arr[i] > 0) {
                st.push(arr[i]);
            } else {
                if(arr[i] < 0){
                    int peek = st.peek();
                    while(!st.empty() && st.peek() > 0 && Math.abs(arr[i]) >= st.peek()){
                        peek = st.peek();
                        st.pop();
                    }
                    if(!st.empty() && st.peek() < 0 && Math.abs(arr[i]) != peek){
                        st.push(arr[i]);
                    }
                    else if( st.empty() && Math.abs(arr[i]) != peek ){
                        st.push(arr[i]);
                    }
                }
            }
           System.out.println(st);
        }
        int k = st.size();
        int res[] = new int[k];
        int n = 0;
        for (int i : st) {
            res[n] = i;
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision sol = new AsteroidCollision();
        int asteroids[]={10,2,-5};
        System.out.println(Arrays.toString(sol.asteroidCollision(asteroids)));
    }
}