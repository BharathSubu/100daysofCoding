//https://leetcode.com/problems/power-of-two/

class PowerOf2 {

    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        if((n & (n-1)) == 0) return true;
        else return false;
    }

  public static void main(String[] args) {
    PowerOf2 sol = new PowerOf2();
    System.out.println(sol.isPowerOfTwo(8));

  }
}