// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

class PredecessorAndSuccessor
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       inorder(root,p,s,key);
    }
    
    public static void inorder(Node root, Res p,Res s,int key){
        if(root != null){
            inorder(root.left,p,s,key);
            if(root.data<key)p.pre = root;
            if(root.data>key ){
                if(s.succ == null)s.succ = root;
            }    
            inorder(root.right,p,s,key);
        }
    }
}
class Res{
    Node pre = null;
    Node succ = null;
}