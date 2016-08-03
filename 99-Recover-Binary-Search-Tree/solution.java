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
    int cur=Integer.MIN_VALUE;
    TreeNode node1=null,node2=null,curnode=null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(node1,node2);
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(node1==null&&cur>=root.val) node1=curnode;
        if(node1!=null&&cur>=root.val) node2=root;
        cur=root.val;
        curnode=root;
        helper(root.right);
    }
    public void swap(TreeNode node1,TreeNode node2){
        int tmp=node1.val;
        node1.val=node2.val;
        node2.val=tmp;
    }
}