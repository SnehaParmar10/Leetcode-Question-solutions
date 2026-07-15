class Solution {
    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, word1, word2);
    }

    int solve(int i, int j, String s1, String s2) {

        if (i == s1.length())
            return s2.length() - j;

        if (j == s2.length())
            return s1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = solve(i + 1, j + 1, s1, s2);

        int deleteFromS1 = 1 + solve(i + 1, j, s1, s2);
        int deleteFromS2 = 1 + solve(i, j + 1, s1, s2);

        return dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
    }
}