class Solution {
    public int minimumCardPickup(int[] cards) {

    HashSet<Integer> set = new HashSet<>();  
    int ans = Integer.MAX_VALUE;
    int j = 0;

    for(int card : cards){
        if(!set.contains(card)){
            set.add(card);
        }else{ 
            while(set.contains(card)){
               ans = Math.min(set.size() + 1, ans);
               set.remove(cards[j++]);
            }
              set.add(card);  
        }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
