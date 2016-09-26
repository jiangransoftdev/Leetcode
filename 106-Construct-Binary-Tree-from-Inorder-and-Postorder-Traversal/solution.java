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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    public TreeNode helper(int[] in,int inl,int inr,int[] post,int pol,int por,Map<Integer,Integer> map){
        if(inl>inr) return null;
        TreeNode root=new TreeNode(post[por]);
        int rsize=inr-map.get(post[por]);
        TreeNode right=helper(in,inr-rsize+1,inr,post,por-rsize,por-1,map);
        TreeNode left=helper(in,inl,inr-rsize-1,post,pol,por-rsize-1,map);
        root.left=left;
        root.right=right;
        return root;
    }
}