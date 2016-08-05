public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res=new ArrayList<>();
        if(tickets.length==0) return res;
        Map<String,List<String>> map=new HashMap<>();
        int total=tickets.length+1;
        for(int i=0;i<tickets.length;i++){
            if(map.containsKey(tickets[i][0])){
                List<String> tmp=map.get(tickets[i][0]);
                listadd(tickets[i][1],tmp);
            }
            else{
                List<String> tmp=new ArrayList<>();
                tmp.add(tickets[i][1]);
                map.put(tickets[i][0],tmp);
            }
        }
        res.add("JFK");
        helper("JFK",map,res,total,1);
        return res;
    }
    public boolean helper(String start,Map<String,List<String>> map,List<String> res,int total,int num){
        if(num>=total) return true;
        if(!map.containsKey(start)||map.get(start).size()==0) return false;
        List<String> list=map.get(start);
        int i=0;
        while(i<list.size()){
            String next=list.remove(i);
            res.add(next);
            if(helper(next,map,res,total,num+1))
                return true;
            res.remove(res.size()-1);
            listadd(next,list);
            i++;
        }
        return false;
    }
    public void listadd(String str,List<String> list){
        if(list.size()==0){
            list.add(str);
            return;
        }
        int i=0;
        while(i<list.size()){
            if(str.compareTo(list.get(i))<=0){
                list.add(i,str);
                return;
            }
            i++;
        }
        list.add(str);
        return;
    }
}