/* 
 * Using HashMap here - TC - O(3N) - O(N)
 * ANd SC - O(N) 
 */
class Solution {
    public String getHint(String secret, String guess) {
        int x = 0; // bulls - digits in the guess that are in the correct position
        int y = 0; // cows  -  digits in the guess that are in your secret number but are located in the wrong position
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : secret.toCharArray()){
           map.put(c, map.getOrDefault(c, 0) + 1);
        }

       for(int i = 0; i < guess.length(); i++){
           char c = guess.charAt(i);
           if(map.containsKey(c) && map.get(c) != 0 && c == secret.charAt(i)){
               map.put(c,map.get(c) - 1);
               x++;
           }
       }
       for(int i = 0; i < guess.length(); i++){
           char c = guess.charAt(i);
           if(map.containsKey(c) && map.get(c) != 0 && c != secret.charAt(i)){
               map.put(c,map.get(c) - 1);
               y++;
           }
       }
       return x + "A" + y + "B";

    }
}






