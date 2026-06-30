// LC 22
class Solution {
    public List<String> generateParenthesis(int n) {

        // Stores all valid parenthesis combinations
        List<String> result = new ArrayList<>();

        // Start backtracking with an empty string
        backtrack(result, "", 0, 0, n);

        return result;
    }

    void backtrack(List<String> result, String current,
                   int open, int close, int n) {

        // If the current string has used all 2*n parentheses,
        // it is a valid combination
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we still have some left
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add a closing parenthesis only if it won't make
        // the sequence invalid (cannot close more than opened)
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
