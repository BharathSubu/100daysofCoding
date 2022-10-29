//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

public class MinimumBitFlipstoConvertNumber {
    public static int  minBitFlips(int start, int goal) {
        int number = start^goal;
        int count = 0;
        while(number!=0){
            number = number & (number -1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(6,7));
    }
}
