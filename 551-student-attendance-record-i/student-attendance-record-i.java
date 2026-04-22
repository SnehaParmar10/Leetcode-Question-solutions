class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                aCount++;
                if (aCount >= 2) return false;
                lCount = 0;
            } else if (c == 'L') {
                lCount++;
                if (lCount >= 3) return false;
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}