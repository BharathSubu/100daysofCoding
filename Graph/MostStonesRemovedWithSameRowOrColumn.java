//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
import java.util.*;
public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DSUbySize ds = new DSUbySize(maxRow + maxCol + 1);
        for (int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
        }

        int max = 0;
        for (int i = 0; i < ds.size.size(); i++) {
            max = Math.max(max,ds.size.get(i));
        }

        return max - 1;

    }
}
