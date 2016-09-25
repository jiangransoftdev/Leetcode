public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> q=new LinkedList<>();
        int i=0,count=0;
        while(i<num.length()){
            while(!q.isEmpty()&&q.peekLast()>num.charAt(i)&&count<k){
                q.pollLast();
                count++;
            }
            q.offer(num.charAt(i));
            i++;
        }
        while(!q.isEmpty()&&count<k){
            q.pollLast();
            count++;
        }
        while(!q.isEmpty()&&q.peek()=='0') q.poll();
        if(q.isEmpty()) return "0";
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()) sb.append(q.poll());
        return sb.toString();
    }
}