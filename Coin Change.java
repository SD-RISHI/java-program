// LC 322
class Solution {
    public int coinChange(int[] coins, int amount) {

        // dp[i] = Minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initialize all amounts as impossible (greater than maximum possible answer)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;

        // Calculate minimum coins required for every amount from 1 to amount
        for (int i = 1; i <= amount; i++) {

            // Try every coin denomination
            for (int coin : coins) {

                // If the coin can contribute to the current amount
                if (coin <= i) {

                    // Choose the minimum between:
                    // 1. Current answer
                    // 2. Using this coin (1 + answer for remaining amount)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] was never updated, return -1
        // Otherwise return the minimum number of coins
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
