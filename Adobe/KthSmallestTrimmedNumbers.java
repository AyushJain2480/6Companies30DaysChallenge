// Not easy 
// Input: nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
// res = [ , , , ]

// For first query trim all the num in nums
// add all the trimmed nums with their index in the list
// sort all the trimmed nums - so that we can find the Kth smallest number and add its index to the res.
// Repeat this process for every query 

// while(!query.isFinished){
// query --> trim --> sort --> findKthSmall --> addItsIndextoresArr
// }
// return res

// there are 4 query so we get only 4 res
// I'm explaining only for query1 rest you can practice
// query1 = [1,1]
// query1[0] is k and query1[1] is trim 
// so trim all the nums nums[j].substr(len - trim) = nums[j].substr(3 - 1) = nums[j].substr(2);
// trimming - [2,3,1,4]
// add in the list with their indexes [{"2",0},{"3",1},{"1",2},{"4",3}]
// after sorting - [{"1",2},{"2",0},{"3",1},{"4",3}]
// k is 1 so we have to find the index of 1st smallest trimmed number i.e {"1",2} --> 2.
// res = {2}
// final output -> res -> [2,2,1,0]

class Solution{
public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        // Trimming each number to its rightmost trim(i) digits
        for (int j = 0; j < nums.length; j++) {
            list.add(new Pair(nums[j].substring(nums[j].length() - queries[i][1]), j));
        }
        // Sorting
        Collections.sort(list, (a, b) -> a.getKey().compareTo(b.getKey()));
        
        //  Store the index of Kth smallest no. in res array 
        res[i] = list.get(queries[i][0] - 1).getValue();
    }
    return res;
}
}
