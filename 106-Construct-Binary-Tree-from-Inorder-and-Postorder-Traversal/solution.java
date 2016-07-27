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
    public TreeNode helper(int[] inorder,int inl,int inr,int[] postorder,int pol,int por,Map<Integer,Integer> map){
        if(inl>inr) return null;
        TreeNode root=new TreeNode(postorder[por]);
        int rsize=inr-map.get(root.val);
        root.right=helper(inorder,inr-rsize+1,inr,postorder,por-rsize,por-1,map);
        root.left=helper(inorder,inl,inr-rsize-1,postorder,pol,por-rsize-1,map);
        return root;
    }
}