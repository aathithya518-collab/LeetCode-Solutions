class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0;
        backtrack(0, n, 0, 0, 0);
        return count;
    }

    private void backtrack(int row, int n, int cols, int diag1, int diag2) {
        if (row == n) {
            count++;
            return;
        }

        // Available spots have 0s in the combined mask; invert to make available spots 1s
        // (1 << n) - 1 limits bitmask length to exactly n bits
        int availablePositions = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (availablePositions != 0) {
            // Pick the lowest set bit (rightmost available column)
            int position = availablePositions & -availablePositions;

            // Clear the picked bit from available positions
            availablePositions &= availablePositions - 1;

            // Recurse to next row:
            // - cols tracks occupied column
            // - diag1 shifts left by 1 for next row
            // - diag2 shifts right by 1 for next row
            backtrack(row + 1, n, cols | position, (diag1 | position) << 1, (diag2 | position) >> 1);
        }
    }
}