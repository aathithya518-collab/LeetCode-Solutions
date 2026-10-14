import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to allow early pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, 
                          List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Prune branches where the candidate exceeds the remaining sum
            if (candidates[i] > remain) break;

            current.add(candidates[i]);
            // Stay at index 'i' because elements can be reused
            backtrack(candidates, remain - candidates[i], i, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}