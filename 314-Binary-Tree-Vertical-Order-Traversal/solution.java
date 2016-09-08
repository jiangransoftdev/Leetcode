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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> col=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        int min=0,max=0;
        col.offer(0);
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                int cur=col.poll();
                if(!map.containsKey(cur)) map.put(cur,new ArrayList<>());
                map.get(cur).add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    col.offer(cur-1);
                    min=Math.min(min,cur-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    col.offer(cur+1);
                    max=Math.max(max,cur+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }
        return res;
    }
}