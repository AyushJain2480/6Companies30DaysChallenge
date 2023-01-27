// use a HashSet to store all the binary substrings of length k that you find in the input string "s" and then check if the size of the HashSet is equal to the total number of possible binary strings of length k.

//(1 << k) is a bit shift operator, where 1 is shifted left by k bits. This is equivalent to multiplying 1 by 2^k. So 1 << k will give the result of 2^k.
class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(k > s.length()) return false;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (1 << k);
    }
}
