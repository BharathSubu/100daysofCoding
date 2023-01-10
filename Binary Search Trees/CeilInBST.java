// https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-ceil-in-bst

import java.util.*;

class CeilInBST {
    // Function to return the ceil of given number in BST.
    int res = -1;

    int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        res = -1;
        ceilElement(root, key);
        return res;
    }

    void ceilElement(Node root, int x) {
        if (root == null)
            return;
        if (root.data == x) {
            res = root.data;
            return;
        }
        ;
        if (root.data > x) {
            res = root.data;
            ceilElement(root.left, x);
        }
        if (root.data < x)
            ceilElement(root.right, x);
    }

}