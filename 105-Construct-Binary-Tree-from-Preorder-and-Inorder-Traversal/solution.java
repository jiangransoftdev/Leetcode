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
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode helper(int[] preorder,int prel,int prer,int[] inorder,int inl,int inr,Map<Integer,Integer> map){
        if(inl>inr) return null;
        TreeNode root=new TreeNode(preorder[prel]);
        int leftsize=map.get(root.val)-inl;
        root.left=helper(preorder,prel+1,prel+leftsize,inorder,inl,inl+leftsize-1,map);
        root.right=helper(preorder,prel+leftsize+1,prer,inorder,inl+leftsize+1,inr,map);
        return root;
    }
}