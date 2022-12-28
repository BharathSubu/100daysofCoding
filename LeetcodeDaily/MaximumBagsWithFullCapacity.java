import java.util.Arrays;

// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
import java.util.*;;
class MaximumBagsWithFullCapacity {
    public  static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int needRocks[] = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            needRocks[i] = Math.abs(capacity[i]-rocks[i]);
            System.out.print(needRocks[i]+" ");
        }
        Arrays.sort(needRocks);
        int i =0;
        while(i<needRocks.length && additionalRocks > 0){
            additionalRocks-=needRocks[i++];
            if(additionalRocks < 0) {
                i--;
                break;
            }
        }

        return i;
    }
    public static void main(String[] args) {
        int capacity[] ={91,54,63,99,24,45,78};
        int rock[] = {35,32,45,98,6,1,25};
        int additonal = 17;
        System.out.println(maximumBags(capacity, rock, additonal));
    }
}