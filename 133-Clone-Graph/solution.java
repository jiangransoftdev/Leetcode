/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }
    public UndirectedGraphNode helper(UndirectedGraphNode node){
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode dup=new UndirectedGraphNode(node.label);
        map.put(node,dup);
        for(UndirectedGraphNode neighbor:node.neighbors){
            UndirectedGraphNode clone=helper(neighbor);
            dup.neighbors.add(clone);
        }
        return dup;
    }
}