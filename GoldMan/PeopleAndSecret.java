class Solution {
    // TC : O(n)
    // SC : O(n)
    public int peopleAwareOfSecret(int n, int delay, int forget) {
       
    long dp[] = new long[n + 1];
    long mod  = (long)1e9 + 7;
    long noOfPeopleSharingSecret = 0;
    long ans = 0;

    // day 1 only one person knows the secret
    dp[1] = 1;

    // i stands for days
    // using Math.max to avoid negative scenarios when i - delay is negative (max is 0 in case of -ve) and (dp[0] = 0 is valid).
    for(int i = 2; i <= n; i++){
    long noOfnewPeopleSharingSecretOnIthDay = dp[Math.max(i - delay , 0)];
    long noOfPeopleForgetSecretOnIthDay = dp[Math.max(i - forget , 0)];
    noOfPeopleSharingSecret += (noOfnewPeopleSharingSecretOnIthDay - noOfPeopleForgetSecretOnIthDay + mod) % mod;

    // dp[i] means the number of people who found the secret on ith day
    dp[i] = noOfPeopleSharingSecret;
    }

    // once we build the dp array we start the iteration from (n - forget + 1 to n)
    // and sum up the elements and store it in ans variable and finally return it 
    for(int i = n - forget + 1 ; i <= n; i++){
        ans = (ans + dp[i]) % mod;
    }
    return (int)ans;
    }
}
