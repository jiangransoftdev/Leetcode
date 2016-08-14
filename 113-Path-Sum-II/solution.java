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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        helper(root,sum,new ArrayList<>(),res);
        return res;
    }
    public void helper(TreeNode root,int sum,List<Integer> solu,List<List<Integer>> res){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                solu.add(root.val);
                res.add(new ArrayList<>(solu));
                solu.remove(solu.size()-1);
            }
            return;
        }
        solu.add(root.val);
        helper(root.left,sum-root.val,solu,res);
        helper(root.right,sum-root.val,solu,res);
        solu.remove(solu.size()-1);
    }
}