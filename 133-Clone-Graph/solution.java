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
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        return dfs(node,map);
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode node,Map<UndirectedGraphNode,UndirectedGraphNode> map){
        if(node==null) return null;
        if(map.containsKey(node))
            return map.get(node);
        UndirectedGraphNode dup=new UndirectedGraphNode(node.label);
        map.put(node,dup);
        List<UndirectedGraphNode> neighbors=node.neighbors;
        for(UndirectedGraphNode neighbor:neighbors){
            UndirectedGraphNode clone=dfs(neighbor,map);
            dup.neighbors.add(clone);
        }
        return dup;
    }
}