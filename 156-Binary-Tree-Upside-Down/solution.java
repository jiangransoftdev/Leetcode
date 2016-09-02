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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode node=root,parent=null,right=null;
        while(node!=null){
            TreeNode left=node.left;
            node.left=right;
            right=node.right;
            node.right=parent;
            parent=node;
            node=left;
        }
        return parent;
    }
}