//https://practice.geeksforgeeks.org/problems/95080eb9efbf7cc5cb4851ddf8d7946e3f212a49/1
public class TypeIt {
        int minOperation(String s) {
            int ans=s.length();
            for(int i=0;i<s.length()/2;i++) {
                boolean isTrue=true;
                int j = 0;
                while(j<=i) {
                    if(s.charAt(j)!=s.charAt(j+i+1)) {
                        isTrue=false;
                        break;
                    }
                    j++;
                }
                if(isTrue) ans = s.length()-i;
            }
            return ans;
        }
}
