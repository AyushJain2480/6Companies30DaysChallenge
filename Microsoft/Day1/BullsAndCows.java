/* 
 * Using HashMap here - TC - O(3N) - O(N)
 * ANd SC - O(N) 
 */
class Solution {
    public String getHint(String secret, String guess) {
        int x = 0; // bulls
        int y = 0; // cows
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : secret.toCharArray()){
           if(!map.containsKey(ch)){
               map.put(ch,1);
           }else{
               map.put(ch , map.get(ch) + 1);
           }
        }
       for(int i = 0; i < guess.length(); i++){
           char ch = guess.charAt(i);
           if(map.containsKey(ch) && map.get(ch) != 0 && ch == secret.charAt(i)){
               map.put(ch,map.get(ch) - 1);
               x++;
           }
       }
       for(int i = 0; i < guess.length(); i++){
           char ch = guess.charAt(i);
           if(map.containsKey(ch) && map.get(ch) != 0 && ch != secret.charAt(i)){
               map.put(ch,map.get(ch) - 1);
               y++;
           }
       }
       return x + "A" + y + "B";

    }
}



