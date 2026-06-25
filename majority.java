class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;  // Size of the array
        int ans = 0;          // Stores the count of valid subarrays

        // Generate all possible subarrays starting from index i
        for (int i = 0; i < n; i++) {

            int targetCount = 0; // Count of target in current subarray

            // Extend subarray from i to j
            for (int j = i; j < n; j++) {

                // If current element equals target, increment count
                if (nums[j] == target) {
                    targetCount++;
                }

                // Current subarray length
                int length = j - i + 1;

                // Check if target is the majority element
                // Majority means frequency > length / 2
                if (targetCount > length / 2) {
                    ans++;
                }
            }
        }

        // Return total number of valid subarrays
        return ans;
    }
}
