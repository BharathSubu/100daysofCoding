//https://practice.geeksforgeeks.org/problems/binary-tree-representation/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=binary-tree-representation
import  java.util.*;

class BinaryTreeRepresentation{
    public static void createTree(Node root0, ArrayList<Integer> v ){
        Queue<Node> qu = new LinkedList<>();
        qu.add(root0);
        int count = 1;
        for(int i=0;i<v.size();i++){
            System.out.println(qu);
            Node temp = qu.poll();
            temp.data = v.get(i);
            if(count < v.size()){
                temp.left = new Node(0);
                count++;
                qu.add(temp.left);
            }
            if(count < v.size()){
                temp.right = new Node(0);
                count++;
                qu.add(temp.right);
            }
        }
    }

    public static class LevelOrderTraversal {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<Integer> sol = new ArrayList<>();
            queue.add(root);
            sol.add(root.val);
            while(queue.size() !=0){
                res.add(new ArrayList<>(sol));
                List<Integer> now= new ArrayList<>(sol);
                sol = new ArrayList<>();
                while(now.size() !=0){
                    TreeNode temp = queue.peek();
                    if(temp.left != null) {
                        queue.add(temp.left);
                        sol.add(temp.left.val);
                    }
                    if(temp.left != null) {
                        queue.add(temp.right);
                        sol.add(temp.right.val);
                    }
                    now.remove(0);
                    queue.remove();
                }
            }
            return res;
        }
    }
}