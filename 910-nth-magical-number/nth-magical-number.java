class Solution {

    public int nthMagicalNumber(int n, int a, int b) {
        
        long mod = 1000000007;
        long lcm = (long)a * b / gcd(a, b);
        
        long low = 1, high = (long)n * Math.min(a, b);
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / a + mid / b - mid / lcm;
            
            if (count < n) low = mid + 1;
            else high = mid;
        }
        
        return (int)(low % mod);
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}