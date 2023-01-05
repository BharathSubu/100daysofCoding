import java.util.*;

public class GeekAndGeekina {
    static long findGoodPairs(int a[], int n, int k){
        HashMap<Long,List<Long>> map = new HashMap<>();
        long len =0;
        for (long i:a ) {
            map.putIfAbsent(i,new ArrayList<>());
            map.get(i).add(len);
            len++;
        }
        long res = 0;

        for (Map.Entry<Long,List<Long>> entry : map.entrySet()) {
            int i = 0;
            List<Long> r = entry.getValue();
            if(!r.isEmpty())
            while (i < r.size()){
                int j = i+1;
                while (j < r.size()){
                    if(r.get(j) - r.get(i) >= k){
                        res+=(r.size()-j);
                        break;
                    }
                    j++;
                }
                i++;
            }
        }
        return res;
    }
}
