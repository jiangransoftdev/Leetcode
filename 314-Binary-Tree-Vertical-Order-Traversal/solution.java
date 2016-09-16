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
        int min=0,max=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> cols=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        cols.offer(0);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                int col=cols.poll();
                if(!map.containsKey(col)) map.put(col,new ArrayList<>());
                map.get(col).add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    cols.offer(col-1);
                    min=Math.min(min,col-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    cols.offer(col+1);
                    max=Math.max(max,col+1);
                }
            }
        }
        for(int i=min;i<=max;i++)
            res.add(map.get(i));
        return res;
    }
}