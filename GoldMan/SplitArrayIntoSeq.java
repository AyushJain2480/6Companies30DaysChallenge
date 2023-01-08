// FM is Frequence Map 
// HM is Hypothetical Map (If a number is available to join a existing subsequence)

// if(FM.get(i) == 0) continue; means check in FM if count of
// an element is 0 that means it is already a part of subseq so skip it simply.

//  Ok so there are 4 main checks
// * What if loop is doing 
// * what else if loop is doing 
// * else one and last return true

// tip :
// * use map.getOrDefault() instead of using map.containsKey() && map.get() > 0 to reduce the code

// * Reduce the count if you add a element in a subseq

// if loop - If the element is present in the HM that means it
// is already a part of a subseq than there is no need to create a new subseq 

// else if - [1,2,3,3,4,4,5,5]
// 1 is not in HM
// 1 will check in FM so it is non zero so it will start its own 
// subseq and take its next 2 consecutives
// Reduce the frequency in FM for i , i + 1 , i + 2 because with i = 1 we find next 2 consecutives i + 1 and i + 2 i.e 2 and 3 so 1,2,3 is creating a subseq so as we use 1,2,3 reduce their freq.
// FM.put(i , FM.get(i) - 1);
// FM.put(i + 1, FM.get(i + 1) - 1);
// FM.put(i + 2, FM.get(i + 2) - 1);

// HM.put(i + 3, HM.getOrDefault(i + 3, 0) + 1);
// this line is important why we are inserting i + 3 in HM
// because in subseq [1,2,3,()] we are creating a space for 4 
// this means if we get a 4 in future then it will join the subsequence created by 1 , 
// instead of creating its own starting from 4

// HM.put(i + 1, HM.getOrDefault(i + 1, 0) + 1); In if loop this line works same as mentioned above and rest two line are just decreasing the count

// else - return false if above both condition are false

// return true - If we can get through all integers and they either 
// creating valid subsequence of 3 or more or they are just appending to the subseq which is already present.

[My LeetCode Post Solution](https://leetcode.com/problems/split-array-into-consecutive-subsequences/solutions/3021756/using-hashmaps-in-java/).

class Solution {
    public boolean isPossible(int[] nums) {

        Map<Integer,Integer> FM = new HashMap<>();
        Map<Integer,Integer> HM = new HashMap<>();

        for(int num : nums){
            FM.put(num,FM.getOrDefault(num,0) + 1);
        }
        
        for(int i : nums){

            if(FM.get(i) == 0) continue;

            if(HM.getOrDefault(i,0) > 0){
                HM.put(i, HM.get(i) - 1);
                HM.put(i + 1, HM.getOrDefault(i + 1, 0) + 1);
                FM.put(i, FM.get(i) - 1);
            }
            else if((FM.getOrDefault(i,0) > 0)&& (FM.getOrDefault(i + 1 , 0) > 0) && (FM.getOrDefault(i + 2 , 0) > 0)){
                FM.put(i , FM.get(i) - 1);
                FM.put(i + 1, FM.get(i + 1) - 1);
                FM.put(i + 2, FM.get(i + 2) - 1);
                HM.put(i + 3, HM.getOrDefault(i + 3, 0) + 1);
            }else{
                return false;
            }
        }
        return true;
    }
}
