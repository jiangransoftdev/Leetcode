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
    int res=0;
    public int longestConsecutive(TreeNode root) {
        helper(root,Integer.MIN_VALUE,0);
        return res;
    }
    public void helper(TreeNode root,int pre,int len){
        if(root==null){
            res=Math.max(res,len);
            return;
        } 
        if(pre+1==root.val){
            len++;
        }
        else{
            res=Math.max(res,len);
            len=1;
        }
        helper(root.left,root.val,len);
        helper(root.right,root.val,len);
    }
}