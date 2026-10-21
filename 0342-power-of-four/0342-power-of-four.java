class Solution {
    public boolean isPowerOfFour(int n) {
        // n > 0: positive check
        // (n & (n - 1)) == 0: ensures exactly one bit is set (power of 2)
        // (n & 0x55555555) != 0: ensures the set bit is in a power-of-4 position
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}