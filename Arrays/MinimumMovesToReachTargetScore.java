public class MinimumMovesToReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target != 1){
            if(target%2 == 0 && maxDoubles > 0){
                count++;
                maxDoubles--;
                target/=2;
            }
            else if(target%2 == 1 &&  maxDoubles == 0){
                count+=target-1;
                target = 1;
            }
            else{
                target--;
                count++;
            }
        }
        return count;
    }
}
