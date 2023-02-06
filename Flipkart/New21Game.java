// I consider this question as hard as **    
// In the game, there are cards with values between 1 and W. The goal is to get a score of K or more points, and the maximum score you can have is N. 
// The code calculates the probability of reaching K or more points by using a mathematical formula.

// The code uses an array dp to store the probability of getting each possible score. It starts with the probability of getting 0 points, which is 100%. 
// Then, it calculates the probability of getting each subsequent score by looking at the probabilities of the previous scores.
// The probability of getting a score is the average of the probabilities of the previous scores divided by W, because there are W possible values on each card.

// The code also keeps track of the sum of the probabilities of the last W scores in a variable called Wsum. If the current score is less than K, 
// the code adds its probability to Wsum. If the current score is equal to or greater than K, the code adds its probability to the final result.

// Finally, the code returns the sum of the probabilities of getting K or more points, which is the probability of winning the game.
  
public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            
            // at this point, i assume that i have with me the sum of the previous w elements
            dp[i] = Wsum / W;
            
            // if the element we are trying to add is less than k, only then we will add
            if (i < K) 
                Wsum += dp[i];
            
            // in case the current i is greater than k we will add it to our answer because at the end we need the sum of dp values from k to n
            else
                res += dp[i];
            
            // adjust the tail end
            if (i - W >= 0)
                Wsum = Wsum -  dp[i - W];
        }
        return res;
    }
// We are adding the probabilities from k to n because the goal of the game is to get a score of K or more points.
// If the score is less than K, the player loses. So, we want to find the sum of the probabilities of getting K or more points.
// That is why we only add the probabilities from k to n.
