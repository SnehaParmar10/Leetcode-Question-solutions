class Solution {
public:
    int maxProfit(int curr, vector<int>& nums, unordered_map<int, int>& memo) {
        if (curr >= nums.size()) {
            return 0;
        }
        if (memo.find(curr) != memo.end()) {
            return memo[curr];
        }
        int rob = nums[curr] + maxProfit(curr + 2, nums, memo);
        int notRob = maxProfit(curr + 1, nums, memo);

        memo[curr] = max(rob, notRob);
        return memo[curr];
    }
    int rob(vector<int>& nums) {
        unordered_map<int, int> memo;
        return maxProfit(0, nums, memo);
        
    }
};