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
    public void helper(TreeNode root,String s,List<String> res){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            String another=s+root.val;
            res.add(another);
            return;
        }
        String another=s+root.val+"->";
        helper(root.left,another,res);
        helper(root.right,another,res);
    }
}