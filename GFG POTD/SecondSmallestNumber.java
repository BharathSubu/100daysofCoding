public class SecondSmallestNumber {
    static String secondSmallest(int S, int D){
        if(D==1 || S==1 || S>=9*D) return "-1";
        boolean isChanged=false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<D;i++) {
            int digit;
            if(S>9) {
                digit=9;
                S-=9;
            } else {
                if(i==D-1) {
                    digit=S;
                } else {
                    if(S>1) {
                        digit=S-1;
                        S=1;
                    } else {
                        digit=0;
                    }
                }
            }
            if(!isChanged && digit<9 && sb.length()>0) {
                digit++;
                char c = sb.charAt(sb.length()-1);
                sb.setCharAt(sb.length()-1,--c);
                isChanged=true;
            }
            sb.append(digit);
        }
        return sb.reverse().toString();
    }
}
