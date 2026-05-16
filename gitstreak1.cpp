#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int n = s1.length();
        int m = s2.length();

        // Check total length and sure the length of the code
        if (n + m != s3.length()) {
            return false;
        }

        // DP table table
        vector<vector<bool>> dp(n + 1, vector<bool>(m + 1, false));

        dp[0][0] = true;

        // First column ad last colum hai yeh
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] &&
                       (s1[i - 1] == s3[i - 1]);
        }

        // First row and the last row of this code
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] &&
                       (s2[j - 1] == s3[j - 1]);
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                dp[i][j] =
                    (dp[i - 1][j] &&
                     s1[i - 1] == s3[i + j - 1])

                    ||

                    (dp[i][j - 1] &&
                     s2[j - 1] == s3[i + j - 1]);
            }
        }

        return dp[n][m];
    }
};
