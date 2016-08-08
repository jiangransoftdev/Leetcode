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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int s,int e){
        if(s>e) return null;
        int m=s+(e-s)/2;
        TreeNode left=helper(nums,s,m-1);
        TreeNode root=new TreeNode(nums[m]);
        TreeNode right=helper(nums,m+1,e);
        root.left=left;
        root.right=right;
        return root;
    }
}