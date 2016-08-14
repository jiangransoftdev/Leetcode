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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        boolean odd=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer> tmp=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                if(odd)
                    tmp.add(node.val);
                else
                    tmp.addFirst(node.val);
            }
            res.add(tmp);
            if(odd) odd=false;
            else odd=true;
        }
        return res;
    }
}