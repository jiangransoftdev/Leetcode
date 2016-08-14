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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();
        if(root==null) return res;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node=s.pop();
            res.addFirst(node.val);
            if(node.left!=null) s.push(node.left);
            if(node.right!=null) s.push(node.right);
        }
        return res;
    }
}