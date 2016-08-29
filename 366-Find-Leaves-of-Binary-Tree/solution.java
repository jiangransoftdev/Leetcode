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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        helper(root,res);
        return res;
    }
    public int helper(TreeNode root,List<List<Integer>> res){
        if(root==null) return -1;
        int level=1+Math.max(helper(root.left,res),helper(root.right,res));
        if(level>res.size()-1) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        return level;
    }
}