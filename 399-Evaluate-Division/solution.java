class Edge{
    String a;
    String b;
    double val;
    public Edge(String a,String b,double val){
        this.a=a;
        this.b=b;
        this.val=val;
    }
}
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String,List<Edge>> map=new HashMap<>();
        for(int i=0;i<equations.length;i++){
            if(!map.containsKey(equations[i][0]))
                map.put(equations[i][0],new ArrayList<>());
            if(!map.containsKey(equations[i][1]))
                map.put(equations[i][1],new ArrayList<>());
            map.get(equations[i][0]).add(new Edge(equations[i][0],equations[i][1],values[i]));
            map.get(equations[i][1]).add(new Edge(equations[i][1],equations[i][0],1.0/values[i]));
        }
        double[] res=new double[queries.length];
        Set<String> set=new HashSet<>();
        for(int i=0;i<queries.length;i++){
            helper(map,queries[i][0],queries[i][1],1.0,res,i,set);
            if(res[i]==0.0) res[i]=-1.0;
        }
        return res;
    }
    public void helper(Map<String,List<Edge>> map,String start,String end,double val,double[] res,int index,Set<String> set){
        if(set.contains(start)) return;
        if(!map.containsKey(start)) return;
        if(start.equals(end)){
            res[index]=val*1.0;
            return;
        }
        set.add(start);
        List<Edge> list=map.get(start);
        for(Edge e:list){
            String b=e.b;
            if(!set.contains(e.b))
                helper(map,e.b,end,val*e.val,res,index,set);
            
        }
        set.remove(start);
    }
}