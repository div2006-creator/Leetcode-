class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        solve(0, s, new StringBuilder(), 0, left, right);

        return ans;
    }
    public void solve(int i, String s, StringBuilder current, int balance, int leftRem, int rightRem) {
        if (balance < 0) {
            return;
        }
        if (i == s.length()) {
            if (balance == 0 && leftRem == 0 && rightRem == 0) {
                String str = current.toString();

                if (!ans.contains(str)) {
                    ans.add(str);
                }
            }
            return;
        }

        char ch = s.charAt(i);

        if (ch == '(') {

            if (leftRem > 0) {
                solve(i + 1, s, current, balance,
                     leftRem - 1, rightRem);
            }
            current.append(ch);
            solve(i + 1, s, current, balance + 1,leftRem, rightRem);
            current.deleteCharAt(current.length() - 1);
        } else if (ch == ')') {
            if (rightRem > 0) {
                solve(i + 1, s, current, balance, leftRem, rightRem - 1);
            }
            current.append(ch);
            solve(i + 1, s, current, balance - 1,
                 leftRem, rightRem);
            current.deleteCharAt(current.length() - 1);

        } else {

            current.append(ch);
            solve(i + 1, s, current, balance,
                 leftRem, rightRem);
            current.deleteCharAt(current.length() - 1);
        }
    }
}