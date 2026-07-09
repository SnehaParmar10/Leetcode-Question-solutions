class Solution {
public:
    unordered_map<int, int>memo;
    int fib(int n) {
        if(n<=1)
        return n;
        if(memo.find(n)!=memo.end()) {
            return memo[n];
        }

        int ans=fib(n-1)+fib(n-2);
        memo[n]=ans;
        return ans; 
        
    }
};