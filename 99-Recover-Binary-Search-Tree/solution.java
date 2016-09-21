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
    TreeNode node1=null,node2=null;
    TreeNode cur=null;
    int curval=Integer.MIN_VALUE;
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp=node1.val;
        node1.val=node2.val;
        node2.val=tmp;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(root.val<=curval){
            if(node1==null) node1=cur;
            if(node1!=null) node2=root;
        }
        cur=root;
        curval=cur.val;
        helper(root.right);
    }
}