public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res=new ArrayList<>();
        int n=tickets.length;
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0],new ArrayList<>());
            List<String> tmp=map.get(tickets[i][0]);
            listadd(tmp,tickets[i][1]);
        }
        res.add("JFK");
        helper("JFK",map,0,n,res);
        return res;
    }
    public void listadd(List<String> tmp,String ticket){
        if(tmp.size()==0){
            tmp.add(ticket);
            return;
        }
        int i=0;
        while(i<tmp.size()){
            if(ticket.compareTo(tmp.get(i))<=0)
                break;
            i++;
        }
        tmp.add(i,ticket);
        return;
    }
    public boolean  helper(String start,Map<String,List<String>> map,int n,int tickets,List<String> res){
        if(n>=tickets) return true;
        if(!map.containsKey(start)||map.get(start).size()==0) return false;
        List<String> des=map.get(start);
        for(int i=0;i<des.size();i++){
            String next=des.remove(i);
            res.add(next);
            if(helper(next,map,n+1,tickets,res)) return true;
            res.remove(res.size()-1);
            listadd(des,next);
        }
        return false;
    }
}