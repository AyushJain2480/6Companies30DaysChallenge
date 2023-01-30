// cnt is the sum of all weights in the input array.
// map is a TreeMap that stores the mapping from accumulated weight to index.
// rnd is a Random object that generates random numbers.
// The constructor takes in an array w of weights, and uses it to calculate the sum of all weights (cnt) and populate the map with accumulated weight as the key and the index as the value.

// The pickIndex method returns a random index. It generates a random number between 0 and cnt and uses the ceilingKey method of the TreeMap to find the smallest key greater than or equal to the random number. The index associated with the key is returned.

// ceilingKey returns the least key greater than or equal to the given key, while higherKey returns the least key strictly greater than the given key.

class Solution {

    int cnt = 0;
    TreeMap<Integer,Integer> map = new TreeMap<>();
    Random rnd = new Random();
    
    public Solution(int[] w) {
        for(int i = 0; i < w.length; i++){
            cnt += w[i];
            map.put(cnt , i);
        }
    }
    
    public int pickIndex() {
        //  int key= map.higherKey(rnd.nextInt(cnt));
        int key = map.ceilingKey(rnd.nextInt(cnt) + 1);
        return map.get(key);
    }
}
