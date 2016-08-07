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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null&&p==null) return true;
        else if((q==null&&p!=null)||(q!=null&&p==null)) return false;
        else if(q.val!=p.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}