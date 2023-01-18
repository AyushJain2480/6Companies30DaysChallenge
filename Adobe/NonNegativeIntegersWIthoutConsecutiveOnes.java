 // Brute Force generating all the binary numbers and traversing all the binary numbers to check consecutive ones
class Solution {
    public int findIntegers(int n) {
        int count = 0; 
        for(int i = 0; i <= n; i++){
           boolean flag = true; 
           String bin =  binary(i);
           if(bin.equals('1') || bin.equals('0')) {
             count++;
             continue;
           }
           for(int j = 0; j < bin.length() - 1; j++){
              if(bin.charAt(j) == '1' && bin.charAt(j + 1) == '1'){
                  flag = false;
                  break;
              }
           }
           if(flag == true){
               count++;
           }
        }
        return count;
    }

// converting Integer decimal to binary and representing it in a string 
    public String binary(int dec){
    String bin = Integer.toBinaryString(dec);
    return bin;
    }
}

 
// Optimised version - this one is accepted but its too tough to get the idea 
class Solution {
    public int findIntegers(int n) {
        // f(k) = f(k-1) + f(k-2), where k>=2, f(0) = 1, f(1) =2;
        // f(k) means the count    without Consecutive Ones, from 0, to 2^k -1;
        // k is the length of binary string , k = len(bin(2^k -1)) for example : f(5) = count( 00000 - 11111),
        // count( 00000 - 11111) = count(00000 - 01111) + count(10000 - 10111) + count(11000 - 11111)
        //                       = count(00000 - 01111) + count(10000 - 10111)
        //                       = f(4) + f(3)
        int[] fn = new int[32];
        fn[0] = 1;
        fn[1] = 2;
        for (int i = 2; i < fn.length; i++) {
            fn[i] = fn[i-1] + fn[i-2];
        }

        char[] binChr = Integer.toBinaryString(n).toCharArray();
        int len = binChr.length -1;
        int ans = 0;
        boolean preBit = false;
        for (int i = 0; i < binChr.length; i++) {
            if(binChr[i] == '1')
            {
                ans = ans + fn[len - i];
                if(preBit)return ans;
                preBit = true;
            }
            else {
                preBit = false;
            }
        }

        // including it's self.
        return ans +1;
}
}


// I personally love this dfs solution its taking more time buts its also accepted 

class Solution {
// We start with 1. And then append 0 everytime and 1 only when previous char is not 1.
// While appending we calculate the value and stop when it exceed n.

// Appending 0 means we multiply the number by 2.
// (Example : num = 101 (5). Append 0; num = 1010 which is nothing but 5*2 = 10)

// Appending 1 means we multiply the number by 2 and add 1
    
	// initial count is 2 for 0 and 1
    int cnt = 2;
    
    public int findIntegers(int n) {
        dfs(1, 1, n);
        return cnt;
    }
    
    // n = 10
    public void dfs(int prev, int num , int n){
        // append 0
       if(num * 2 <= n){ // first check before appending 0 is it exceeed after appending if yes dont append
           // (1 * 2 <= 10) means we can append 0 
          count++; // increase the count becoz it is safe  count = 3
          dfs(0,num * 2, n);  // 10 <-- multiplying it by 2 becoz  (1 is shifted to left 1 time ){2^1, 2^0} so it will multiplied by 2
        }
        // append 1
       if(prev != 1 && num * 2 + 1 <= n){ // if prev=1 means it is consec 1 so dont append because we will call dfs only for non consec 1              
           count++; // for eg (100) prev = 0 so no problem there and 100 is 4 so 4 * 2 + 1 (9 <= 10) its safe 
           dfs(1,num * 2 + 1 , n); // 1001 --> 1 is shifted to the left so 2 multiplied and 1 is appended at 2^0 position so add 1
        }
    }
}
