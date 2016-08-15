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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root;
        while(!s.isEmpty()||cur!=null){
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            TreeNode node=s.pop();
            res.add(node.val);
            cur=node.right;
        }
        return res;
    }
    
}