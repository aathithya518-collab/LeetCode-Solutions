class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        
        int count = 0;
        // Use long to prevent integer overflow when i * 10 exceeds Integer.MAX_VALUE
        for (long i = 1; i <= n; i *= 10) {
            long higher = n / (i * 10);
            long curr = (n / i) % 10;
            long lower = n % i;
            
            if (curr == 0) {
                count += higher * i;
            } else if (curr == 1) {
                count += higher * i + (lower + 1);
            } else { // curr > 1
                count += (higher + 1) * i;
            }
        }
        
        return count;
    }
}