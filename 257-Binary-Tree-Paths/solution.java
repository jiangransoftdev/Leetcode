/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        helper(root,"",res);
        return res;
    }
    public void helper(TreeNode root,String solu,List<String>res){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            solu=solu+root.val;
            res.add(solu);
            return;
        }
        solu=solu+root.val+"->";
        helper(root.left,solu,res);
        helper(root.right,solu,res);
    }
}