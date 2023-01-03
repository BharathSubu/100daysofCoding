// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";

        Queue<TreeNode> qu = new LinkedList<>();
        if(root!=null)
        {
            qu.add(root);
            res+=Integer.toString(root.val);
            res+=",";
        }
        else return res;
        while (!qu.isEmpty()){
            Queue<TreeNode> qu2 = new LinkedList<>();
            while (qu.size()!=0)
            {
                TreeNode temp =  qu.poll();

                if(temp.left!= null){
                    qu2.add(temp.left);
                    res+=Integer.toString(temp.left.val);
                    res+=",";
                }
                else{
                    res+="null,";
                }

                if(temp.right!= null){
                    qu2.add(temp.right);
                    res+=Integer.toString(temp.right.val);
                    res+=",";
                }
                else{
                    res+="null,";
                }
            }
            qu = new LinkedList<>(qu2);
        }
        return res.substring(0,res.length()-1);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        String [] arr = data.split(",");

        for (String s:   arr  ) {

        }
    }
}
