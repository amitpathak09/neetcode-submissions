class Twitter {

    private int timestamp;

    //map of users and their list of followees
    Map<Integer,List<Integer>> users;

    //map of userId vs Deque of tweets with timestamps and tweetId
    Map<Integer,Deque<int[]>> usersTweets;


    public Twitter() {
        timestamp=0;
        users = new HashMap<>();
        usersTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        //initialize the user if they're not present
        if(!users.containsKey(userId)) {
            users.put(userId, new ArrayList<>());
        }

        //initializing userTweets
        Deque<int[]> userTweets = usersTweets.getOrDefault(userId, new ArrayDeque<>());
        timestamp++;

        int[] tweet = new int[]{timestamp, tweetId};
        userTweets.offerLast(tweet);
        while(userTweets.size()>10) {
            userTweets.pollFirst();
        }
        usersTweets.put(userId, userTweets);        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.addAll(usersTweets.getOrDefault(userId, new ArrayDeque<>()));
        List<Integer> followees = users.getOrDefault(userId, new ArrayList<>());
        for(Integer followee: followees) {
            pq.addAll(usersTweets.getOrDefault(followee, new ArrayDeque<>()));
        }

        while(pq.size()>10) {
            pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            int[] tweet = pq.poll();
            res.add(tweet[1]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        List<Integer> followees = users.getOrDefault(followerId, new ArrayList<>());
        if(followees.contains(followeeId)) {
            return;
        }
        followees.add(followeeId);
        users.put(followerId, followees);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followees = users.getOrDefault(followerId, new ArrayList<>());
        followees.remove(Integer.valueOf(followeeId));
        users.put(followerId, followees);
    }
}
