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
        while(!s.isEmpty()||root!=null){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            TreeNode cur=s.pop();
            res.add(cur.val);
            root=cur.right;
        }
        return res;
    }
}