class SetRightMost {
    static int setBit(int N){
       if((N & (N+1)) == 0) return N;
       return (N|(N+1));
    }
}