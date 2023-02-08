// Approach 1 is simple backtracking 

// Approach 2 - It takes time as we are using two loops here 
// From the last to start , the leftmost position that can reach the current position
class Solution {
    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int jumps = 0;
        while(pos != 0){
            for(int i = 0; i < pos; i++){
                if(i + nums[i] >= pos){
                    pos = i;
                    jumps++;
                    break;
                }
            }
        }
        return jumps;
    }
}

// Approach 3 - Better - O(N) - 1ms - linear 
// The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that 
// all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest,
// then keep the above steps, as the following: 
    
// This is an implicit bfs solution. i == curEnd means you visited all the items on the current level. Incrementing jumps++ is like incrementing
// the level you are on. And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
    
    public int jump(int[] nums) {
        int curEnd = 0, curFarthest = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            // reach directly 
            if (curFarthest >= nums.length - 1) {
               return jump + 1;
            }
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    } 
}

// Approach 4
// Ladder and Stairs - O(N) - Linear
// At Every Index you collect a ladder keep it if it is large enough and throw it if it is small
// and keep climbing your current ladder. If your current ladder is over use the ladder that you have stored.

public int jump(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        int ladder = arr[0];
        int stairs = arr[0];
        int jump = 1;
        for (int level = 1; level < n - 1; level++) {
            if (level + arr[level] > ladder) {
                ladder = level + arr[level];
            }
            stairs -= 1;
            if (stairs == 0) {
                jump += 1;
                stairs = ladder - level;
            }
        }
        return jump;
    }
