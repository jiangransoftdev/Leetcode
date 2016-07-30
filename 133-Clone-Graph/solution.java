/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Queue<UndirectedGraphNode> q=new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode nodecopy=new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        map.put(node,nodecopy);
        while(!q.isEmpty()){
            UndirectedGraphNode cur=q.poll();
            for(int i=0;i<cur.neighbors.size();i++){
                UndirectedGraphNode neighb=cur.neighbors.get(i);
                if(!map.containsKey(neighb)){
                    UndirectedGraphNode neighbcopy=new UndirectedGraphNode(neighb.label);
                    map.get(cur).neighbors.add(neighbcopy);
                    map.put(neighb,neighbcopy);
                    q.offer(neighb);
                }
                else map.get(cur).neighbors.add(map.get(neighb));
            }
        }
        return nodecopy;
    }
}