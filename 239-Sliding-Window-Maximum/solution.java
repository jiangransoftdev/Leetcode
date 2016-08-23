public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length,index=0;
        if(k==0) return new int[0];
        int[] res=new int[n-k+1];
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&q.peek()<i-k+1) q.poll();
            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i]) q.pollLast();
            q.offer(i);
            if(i>=k-1)
                res[index++]=nums[q.peek()];
        }
        return res;
    }
}