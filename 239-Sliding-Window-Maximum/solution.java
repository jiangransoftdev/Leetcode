public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        Deque<Integer> q=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty()&&q.peek()+k<=i)  q.poll();
            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i]) q.pollLast();
            q.offer(i);
            if(i>=k-1){
                res[index++]=nums[q.peek()];
            }
        }
        return res;
    }
}