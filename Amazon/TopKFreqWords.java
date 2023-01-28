class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        // Storing keys only , previously we are storing the object itself
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> 
        map.get(b) - map.get(a) != 0 ? map.get(b) - map.get(a) : a.compareTo(b));

        pq.addAll(map.keySet());  
        
        while(k > 0){ 
            res.add(pq.poll());
            k--;
        }
        return res;
    }
}

