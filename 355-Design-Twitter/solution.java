class Tweet{
    int tweetId;
    int timestamp;
    public Tweet(int tweetId,int timestamp){
        this.tweetId=tweetId;
        this.timestamp=timestamp;
    }
}
public class Twitter {
    Map<Integer,List<Tweet>> tweetmap;
    Map<Integer,Set<Integer>> followmap;
    int time;
    /** Initialize your data structure here. */
    public Twitter() {
        tweetmap=new HashMap<>();
        followmap=new HashMap<>();
        time=0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet twt=new Tweet(tweetId,time);
        if(!tweetmap.containsKey(userId))
            tweetmap.put(userId,new ArrayList<>());
        tweetmap.get(userId).add(twt);
        time++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return tweetmap.get(b[0]).get(b[1]).timestamp-tweetmap.get(a[0]).get(a[1]).timestamp;
            }
        });
        Set<Integer> followset=new HashSet<>();
        followset.add(userId);
        if(followmap.containsKey(userId)) followset.addAll(followmap.get(userId));
        for(int f:followset){
            if(tweetmap.containsKey(f)){
                List<Tweet> tweets=tweetmap.get(f);
                if(tweets.size()>0)
                    pq.offer(new int[]{f,tweets.size()-1});
            }
        }
        while(res.size()<10&&pq.size()>0){
            int[] i=pq.poll();
            res.add(tweetmap.get(i[0]).get(i[1]).tweetId);
            if(i[1]>0)
                pq.offer(new int[]{i[0],i[1]-1});
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followmap.containsKey(followerId))
            followmap.put(followerId,new HashSet<>());
        followmap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!followmap.containsKey(followerId)) return;
        followmap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */