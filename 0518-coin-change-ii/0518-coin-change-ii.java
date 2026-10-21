class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // Outer loop over coins ensures each coin denomination is processed in order,
        // avoiding counting permutations of the same combination.
        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] += dp[x - coin];
            }
        }

        return dp[amount];
    }
}