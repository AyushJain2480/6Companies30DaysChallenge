class TweetCounts {

    // String key is the tweet handle, second is the count by timestamp for that tweet
    Map<String, TreeMap<Integer, Integer>> map = null;
    
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.putIfAbsent(tweetName , new TreeMap<>());
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        tweetMap.put(time, tweetMap.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        if(!map.containsKey(tweetName))return ans;
        
        int gap = 60;
        switch (freq) {
            case "hour":
                gap = 3600;
                break;
            case "day":
                gap = 3600 * 24;
                break;
        }
        
        for(int t = startTime; t <= endTime; t += gap){
            int count = 0;
            int end = Math.min(t + gap , endTime + 1);
            for(int subCount : map.get(tweetName).subMap(t, true, end, false).values()) 
                count += subCount;
            ans.add(count);
        }
        return ans;
    }
}

