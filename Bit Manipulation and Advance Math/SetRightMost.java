//https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1

class SetRightMost {
    static int setBit(int N){
       if((N & (N+1)) == 0) return N;
       return (N|(N+1));
    }
}