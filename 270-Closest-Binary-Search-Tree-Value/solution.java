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
    double diff=Double.MAX_VALUE;
    int res=0;
    public int closestValue(TreeNode root, double target) {
        helper(root,target);
        return res;
    }
    public void helper(TreeNode root,double target){
        if(root==null) return;
        if(diff>Math.abs(target-(double)root.val)){
            res=root.val;
            diff=Math.abs(target-(double)root.val);
        } 
        if(root.val==target) return;
        else if(root.val<target) helper(root.right,target);
        else helper(root.left,target);
    }
}