/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Result{
    int size;
    int lower;
    int upper;
    public Result(int size,int lower,int upper){
        this.size=size;
        this.lower=lower;
        this.upper=upper;
    }
}
public class Solution {
    int max=0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    public Result helper(TreeNode root){
        if(root==null) return new Result(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Result left=helper(root.left);
        Result right=helper(root.right);
        if(left.size==-1||right.size==-1||root.val<=left.upper||root.val>=right.lower)
            return new Result(-1,0,0);
        int size=left.size+right.size+1;
        max=Math.max(size,max);
        return new Result(size,Math.min(left.lower,root.val),Math.max(right.upper,root.val));
    }
}