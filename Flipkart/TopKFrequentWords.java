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
