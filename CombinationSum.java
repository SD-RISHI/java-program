class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Stores all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Start backtracking from index 0
        solve(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void solve(int[] candidates,int target,int start,List<Integer> path,List<List<Integer>> result) {
              
        // Base Case:
        // If target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // If target becomes negative, this path is invalid
        if (target < 0) {
            return;
        }

        // Try each candidate starting from 'start'
        for (int i = start; i < candidates.length; i++) {

            // Choose the current candidate
            path.add(candidates[i]);

            // Explore further
            // 'i' is passed again because the same number
            // can be used multiple times
            solve(
                candidates,
                target - candidates[i],
                i,
                path,
                result
            );

            // Backtrack: remove the last chosen element
            path.remove(path.size() - 1);
        }
    }
}
