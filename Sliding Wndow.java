import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Stores unique characters in current window
        HashSet<Character> set = new HashSet<>();

        int max = 0;
        int left = 0;

        // Expand window
        for (int right = 0; right < s.length(); right++) {

            // Remove characters until duplicate disappears
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update maximum length
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
