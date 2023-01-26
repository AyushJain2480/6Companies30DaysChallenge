class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        // create a freq map
        for(String word : words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) ->{
            if(b.getValue() - a.getValue() != 0){
                // sort the elements by frequency in descending order
                return b.getValue() - a.getValue();
            }else{
                // sort the elements with the same frequency by their lexicographical order
                return a.getKey().compareTo(b.getKey());
            }   
        });
        pq.addAll(map.entrySet());       
        
        while(k > 0){
            Map.Entry<String, Integer> entry = pq.poll(); 
            res.add(entry.getKey());
            k--;
        }

        return res;
    }
}


// More readable

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
