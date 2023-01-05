public class InsertIntoABST {
    public TreeNode insertIntoBST(TreeNode root, int val) {        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        else{
            insertIntoBST( root ,  val , 0);
        }
        return root;
    }
    void insertIntoBST(TreeNode root , int val , int pos){

        if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
                return;
            }
            else{
                insertIntoBST(root.left , val,0);
            }
        }
        else{
            if(root.right == null){
                root.right = new TreeNode(val);
                return;
            }
            else{
                insertIntoBST(root.right , val,0);
            }
        }
    }
}
