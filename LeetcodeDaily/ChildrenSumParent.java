//https://practice.geeksforgeeks.org/problems/children-sum-parent/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=hildren-sum-parent

import java.nio.file.DirectoryStream;
import java.util.*;

public class ChildrenSumParent {
    public static int isSumProperty(Node root)
    {
       if(isChildSum(root)) return 1;
       return 0;
    }

    private static boolean isChildSum(Node root) {
        if(root == null) return true;
        int lft = root.left != null ? root.left.data : 0;
        int rgt = root.right != null ? root.right.data : 0;
        if(root.data == (lft + rgt)){
            if(isChildSum(root.left)) return isChildSum(root.right);
            else return false;
        }
        else if((lft+rgt)==0) return true;
        else return false;
    }
}
