class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (String word : map.keySet()) {
            int j = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == word.charAt(j)){
                    j++;
                }
                if(j >= word.length()){
                    ans += map.get(word);
                    break;
                }
            }
        }
        return ans;
    }
}
