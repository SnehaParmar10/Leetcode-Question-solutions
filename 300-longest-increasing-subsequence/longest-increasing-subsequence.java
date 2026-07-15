class Solution {
    int solve(int prev, int cur, int[] nums, int[][] dp) {
        if (cur == nums.length) {
            return 0;
        }
        if (dp[prev + 1][cur] != -1) {
            return dp[prev + 1][cur];
        }
        int notTake = solve(prev, cur + 1, nums, dp);
        int take = 0;
        if (prev == -1 || nums[cur] > nums[prev]) {
            take = 1 + solve(cur, cur + 1, nums, dp);
        }
        return dp[prev + 1][cur] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(-1, 0, nums, dp);
    }
}