//https://leetcode.com/problems/string-compression/submissions/907447019/
public class StringCompression {
    public int compress(char[] chars) {
        String s = "";
        char prev = chars[0];
        int previ =0;
        int i = 1;
        while(i != chars.length){
            if(prev != chars[i]){
                s+=prev;
                int count = i - previ ;
                if(count > 1){
                    s+=Integer.toString(count);
                }
                prev = chars[i];
                previ = i;
            }
            i++;
        }
        s+=prev;
        int count = i - previ ;
        if(count > 1){
            s+=Integer.toString(count);
        }
        for( i  = 0;i<s.length() ;i++) chars[i] = s.charAt(i);
        return s.length();
    }
}
