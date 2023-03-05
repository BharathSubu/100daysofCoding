//https://practice.geeksforgeeks.org/problems/a3493283697b7b69573a840f371a55ccd9332bb0/1
import java.util.*;
public class BestNode {
    public static long bestNode(int N, int[] A, int[] P) {
        HashSet<Integer> parentSet = new HashSet<>();
        for(int parent: P)parentSet.add(parent);
        ArrayList<Integer> leafNodes = new ArrayList<>();
        for(int i = 1; i <= P.length; i++){
            if(!parentSet.contains(i))leafNodes.add(i);
        }
        int maxiSum = Integer.MIN_VALUE;
        for(int leaf: leafNodes){
            int currentNode = leaf;
            int currentSum = 0;
            while(currentNode != -1){
                currentSum *= -1;
                currentSum += (A[currentNode-1]);
                maxiSum = Math.max(maxiSum, currentSum);
                currentNode = P[currentNode-1];
            }
        }
        return maxiSum;
    }
}
