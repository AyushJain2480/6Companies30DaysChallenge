class Solution{
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n  = creators.length;
        List<List<String>> res = new ArrayList<>();
        
        TreeMap<String, Long> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String g = creators[i];
            map.put(g, map.getOrDefault(g, (long)0) + views[i]);
        }
        
        // if one creator creates two videos one has 5 views and other has 7 views 
        //  than store the higher views. 
        TreeMap<String,Integer> k = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String g = creators[i];
            if(k.containsKey(g)){
                if(k.get(g) < views[i])
                    k.put(g,views[i]);
            }else{
                k.put(g,views[i]);
            }
        }
        
        // If the two videos of the same creator have equal no of views than we have to store both the ids
        // in the TreeSet and find the lexicographically smallest id
        // but if one video has 5 views and other has 7 views than we store the id of the video that has 7 views 
        // because we want to find the id of their most viewed video.
        HashMap<String,TreeSet<String>> ts = new HashMap<>();
        for(int i = 0; i < n; i++){
            String g = creators[i];
            
            if(!ts.containsKey(g))
                ts.put(g,new TreeSet<String>());
      
            if(k.get(g) == views[i])
                ts.get(g).add(ids[i]);
        }
        
        // find the video having maximum no of views from map.
        long max = Collections.max(map.values());
        
        // finding the id for the maximum viewed video using map & ts.
        // storing it in f List [creator , id] and than in final List res.
         
        for(Map.Entry<String,Long> entry : map.entrySet()){
            if(entry.getValue() == max){
                List<String> f = new ArrayList<>();
                f.add(entry.getKey());
                f.add(ts.get(entry.getKey()).first());
                res.add(f);
            }
        }
        return res; 
    }
}
