//https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
public class CountNoBits {
    //TLE
//    public static int countSetBits(int n){
//        int count = 0;
//        while(n!=0){
//            int temp = n;
//            int step = 0;
//            while(temp!=0){
//                step++;
//                temp = temp&(temp-1);
//            }
//            count+=step;
//            n--;
//        }
//        return count;
//    }

    public static int countSetBits(int n){
        int count = 0;
        while (n > 0){
            int power = (int) Math.ceil( (int)(Math.log(n) / Math.log(2)));
            count+=((1<<(power-1))*power);
            count+=(n - (1<<power));
            count++;
            n = n - (1<<power) ;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSetBits(4));
    }
}
