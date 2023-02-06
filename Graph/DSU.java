//https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
import java.util.*;
public class DSU {
    public static void main(String[] args) {
        DSUbyRank d = new DSUbyRank(7);
        d.unionByRank(1,2);
        d.display();
        d.unionByRank(2,3);
        d.display();
        d.unionByRank(4,5);
        d.display();
        d.unionByRank(6,7);
        d.display();
        d.unionByRank(5,6);
        d.display();
        d.unionByRank(3,7);
        d.display();
    }
}
