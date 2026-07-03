//Dynammic programming
//Edit Distance
//LC 72

class Solution {
    public int minDistance(String word1, String word2) {

        // Get the lengths of both words
        int m = word1.length();
        int n = word2.length();

        // DP table where dp[i][j] represents the minimum edit distance
        // between the first i characters of word1 and the first j characters of word2
        int[][] dp = new int[m + 1][n + 1];

        // Base case: Convert word1 to an empty string (delete all characters)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Base case: Convert an empty string to word2 (insert all characters)
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match, no operation is needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // If characters don't match, consider:
                // 1. Replace  (dp[i-1][j-1])
                // 2. Delete   (dp[i-1][j])
                // 3. Insert   (dp[i][j-1])
                // Take the minimum of the three operations
                else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],      // Replace
                            Math.min(
                                dp[i - 1][j],      // Delete
                                dp[i][j - 1]       // Insert
                            )
                    );
                }
            }
        }

        // Return the minimum number of operations required
        return dp[m][n];
    }
}
