// I feel this one is good and tough question as well - asked in my mock interview

// dp[i - delay] people found the secret delay days before,starting to share the secret.
// Itne logo ko secret pata tha lekin delay time tak nhi bol skte the lekin ab bolege ye log share me add honge
// share += dp[i - delay]

// dp[i - forget]  people found the secret forget days before,and forgot the secret today.
// Itne logo ko secret pata tha or ye share bhi krre the lekin ab forgot day agya mtlb ye bhul jayge secret to share ni karpayge
// to share me se hata do in logo ko 
// share -= dp[i - forgot]

// dp[i] means the number of people who found the secret on ith day.
// share is the number of people who are going to share the secrets.

//dp[i] represent no. of people who get secret on i th day and those people who get the secret before (n-forget+1)th day, they forgot the secret so they will not contribute on the nth day.

// For confusion : dp[i] represent no of people got secret on ith day, not no of people know secret on ith day

// Input: n = 6, delay = 2, forget = 4
// [0, 1, 0, 1, 1, 1, 2]
//    d1 d2 d3 d4 d5 d6
// at day 0 no one knows about secret
// at day 1 one new person knows about secret
// at day 2 no new person knows about secret
// at day 3 1 ...
// at day 4 1 ...
// at day 5 1 ...
// at day 6 2 ...

// we want total number of person who knows about the secret at day 6
// the person who knows about the secret at day 1 will forgot the secret at day 6 because forgot = 4
// same for person who knows about the secret at day 2 will forgot the secret at day 6
// only the new persons at day 3,4,5 and 6 will not forgot the secret on day 6 so sum up and return it.



class Solution {
 
    public int peopleAwareOfSecret(int n, int delay, int forget) {
       long dp[] = new long[n + 1], mod = (long)1e9 + 7, share = 0, ans = 0;
       dp[1] = 1;
       
       for(int i = 1; i <= n; i++){
           if(i > 1){
               share = dp[i] = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget,0)]) % mod;
           }
           if(i >= n-forget+1){
               ans = (ans + dp[i]) % mod;
           }
       } 
       int finalAns = (int)ans;
       if(finalAns < 0) finalAns += (int)mod;
       return finalAns;
    }
}

