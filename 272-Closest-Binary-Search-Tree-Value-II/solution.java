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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res=new ArrayList<>();
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        inorder(root,true,target,s1);
        inorder(root,false,target,s2);
        while(k-->0){
            if(s2.isEmpty())
                res.add(s1.pop());
            else if(s1.isEmpty())
                res.add(s2.pop());
            else if(Math.abs(s1.peek()-target)<Math.abs(s2.peek()-target))
                res.add(s1.pop());
            else res.add(s2.pop());
        }
        return res;
    }
    public void inorder(TreeNode root,boolean r,double target,Stack<Integer> s){
        if(root==null) return;
        inorder(r?root.left:root.right,r,target,s);
        if((r&&root.val>target)||(!r&&root.val<=target)) return;
        s.push(root.val);
        inorder(r?root.right:root.left,r,target,s);
    }
}