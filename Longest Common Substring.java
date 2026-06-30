//LC 1143
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // Lengths of both strings
        int n = text1.length();
        int m = text2.length();

        // dp[i][j] = Length of LCS between
        // first i characters of text1 and first j characters of text2
        int[][] dp = new int[n + 1][m + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If current characters match,
                // include this character in the LCS
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // If they don't match,
                // take the maximum LCS by excluding one character
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Bottom-right cell contains the LCS length
        return dp[n][m];
    }
}
