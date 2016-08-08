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
    int i=0;
    public int kthSmallest(TreeNode root, int k) {
        int res=Integer.MAX_VALUE;
        if(root==null) return res;
        int left=kthSmallest(root.left,k);
        i++;
        if(i==k) res=root.val;
        int right=kthSmallest(root.right,k);
        if(left!=Integer.MAX_VALUE) return left;
        if(right!=Integer.MAX_VALUE) return right;
        if(res!=Integer.MAX_VALUE) return res;
        return Integer.MAX_VALUE;
    }
    
}