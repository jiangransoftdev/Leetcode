class Tweets{
    int time;
    int id;
    public Tweets(int time,int id){
        this.time=time;
        this.id=id;
    }
}
public class Twitter {
    Map<Integer,HashSet<Integer>> followmap;
    Map<Integer,List<Tweets>> tweetmap;
    int count;
    /** Initialize your data structure here. */
    public Twitter() {
        count=0;
        followmap=new HashMap<>();
        tweetmap=new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweetmap.containsKey(userId)){
            List<Tweets> tmp=new ArrayList<>();
            tmp.add(new Tweets(count,tweetId));
            tweetmap.put(userId,tmp);
        }
        else tweetmap.get(userId).add(new Tweets(count,tweetId));
        count++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> res=new LinkedList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return tweetmap.get(b[0]).get(b[1]).time-tweetmap.get(a[0]).get(a[1]).time;
            }
        });
        Set<Integer> followeeset=new HashSet<>();
        followeeset.add(userId);
        if(followmap.containsKey(userId))
            followeeset.addAll(followmap.get(userId));
        for(int followee:followeeset){
            if(tweetmap.containsKey(followee)){
                List<Tweets> list=tweetmap.get(followee);
                if(list.size()>0)
                    pq.offer(new int[]{followee,list.size()-1});
            }
        }
        while(res.size()<10&&pq.size()>0){
            int[] tmp=pq.poll();
            res.add(tweetmap.get(tmp[0]).get(tmp[1]).id);
            tmp[1]--;
            if(tmp[1]>=0)
                pq.offer(tmp);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followmap.containsKey(followerId))
            followmap.get(followerId).add(followeeId);
        else{
            HashSet<Integer> tmp=new HashSet<>();
            tmp.add(followeeId);
            followmap.put(followerId,tmp);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
         HashSet<Integer> follow=followmap.get(followerId);
        if(follow==null){
        	follow=new HashSet<Integer>();
        	followmap.put(followerId, follow);
        }
        follow.remove(followeeId);
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