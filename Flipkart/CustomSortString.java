
class Solution {
    public String customSortString(String order, String s) {
        // c --> 0
        // b --> 1
        // a --> 2
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i) , i);
        }
        
        // e ---> 2
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0) + 1);
        }
        
        // {dcba}
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            int aVal = map.getOrDefault(a, Integer.MAX_VALUE);
            int bVal = map.getOrDefault(b, Integer.MAX_VALUE);
            return aVal - bVal;
        });
        pq.addAll(freqMap.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll(); // e
            int freq = freqMap.get(ch); // 2
            while(freq-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}


class Solution {
    public String customSortString(String order, String s) {
        
        // creating the frequency of each character using hashmap
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        
        String res = "";
        // First we append the characters into res that are present in the orders
        for(char ch : order.toCharArray()){
            if(!map.containsKey(ch)) continue; //  If the string character is not present in the order string
            int freq = map.get(ch);
            while(freq-- > 0){
                 res += Character.toString(ch); // appending the result
            }
            map.remove(ch); // freeing the hashmap
        }
        
        // Appending Remaining characters that are not present in the order string (left in map becoz of removal of characters that are present in order)
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            while(freq-- > 0){
                res += Character.toString(ch);
            }
        }
        return res; 
    }
}
