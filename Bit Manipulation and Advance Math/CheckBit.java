//https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
       System.out.println(n+" "+(1<<k));
       if((n& (1<<k))!=0) return true;
       return false;
    }
    public static void main(String[] args) {
        System.out.println(checkKthBit(4, 0));
    }
}