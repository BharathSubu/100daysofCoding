public class Problems {

    public static boolean isHappy(int n) {
        int slow = n ;
        int fast = n ;
        do{
            slow = square(slow);
            fast = square(fast);
            fast = square(fast);
            System.out.println(slow + " " + fast);
            if(slow == 1 || fast == 1) return true;
        }while(slow != fast);
        return false;
    }
    public static int square(int n){
        int res = 0;
        while(n>0){
            int rem = n%10;
            res += rem*rem;
            n = n/10;
        }
        return  res;
    }

    public static void main(String[] args) {
        int n = 19;
        if(isHappy(n)) System.out.println("TRUE");
        else System.out.println("FALSE");
    }
}
