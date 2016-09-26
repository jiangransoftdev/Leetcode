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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode helper(int[] pre,int prel,int prer,int[] in,int inl,int inr,Map<Integer,Integer> map){
        if(inl>inr) return null;
        TreeNode root=new TreeNode(pre[prel]);
        int lsize=map.get(pre[prel])-inl;
        TreeNode left=helper(pre,prel+1,prel+lsize,in,inl,inl+lsize-1,map);
        TreeNode right=helper(pre,prel+lsize+1,prer,in,inl+lsize+1,inr,map);
        root.left=left;
        root.right=right;
        return root;
    }
}