// Longest common Subsequences.
// Dynammic programming (Bottom-up Approach)
// LC 1143

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // Get the lengths of both strings
        int n = text1.length();
        int m = text2.length();

        // DP table where dp[i][j] stores the LCS length
        // between first i characters of text1 and first j characters of text2
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match, extend the previous LCS
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                // If characters don't match, take the maximum
                // LCS by excluding one character from either string
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the length of the Longest Common Subsequence
        return dp[n][m];
    }
}
