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
