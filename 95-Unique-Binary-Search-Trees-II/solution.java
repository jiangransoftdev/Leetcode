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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=new ArrayList<>();
        if(n==0) return res;
        return helper(1,n);
    }
    public List<TreeNode> helper(int s,int e){
        List<TreeNode> res=new ArrayList<>();
        if(s>e){
            res.add(null);
            return res;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode> left=helper(s,i-1);
            List<TreeNode> right=helper(i+1,e);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}