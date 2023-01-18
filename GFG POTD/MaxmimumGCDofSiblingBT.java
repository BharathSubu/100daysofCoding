//https://practice.geeksforgeeks.org/problems/6eb51dc638ee1b936f38d1ab4b2f7062d4425463/1

    class MaxmimumGCDofSiblingBT {
        Node max = null;
        int g = 0;
        int maxGCD(Node root) {
            if(root == null) return 0;
            max = root;
            gcd(root);
            return g==0 ? 0 :  max.data;
        }

        int gcd (Node root){
            if(root == null) return 0;
            int l = gcd(root.left);
            int r = gcd(root.right);
            if( l==0 || r == 0) return root.data;
            int ccd = gcdN(l,r);
            if(ccd > g) {
                max = root;
                g = ccd;
            }
            return root.data;
        }
        int gcdN (int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcdN(b, a % b);
        }
    }

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

