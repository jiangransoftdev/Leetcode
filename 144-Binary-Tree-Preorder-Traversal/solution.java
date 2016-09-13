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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node=s.pop();
            res.add(node.val);
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
        }
        return res;
    }
}