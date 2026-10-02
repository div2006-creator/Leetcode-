import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fun("", n, 0, 0, ans);
        return ans;
    }
    public void fun(String s, int n, int a, int b, List<String> ans) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }
        if (a > n || b > n) return;
        if (a < n) {
            fun(s + "(", n, a + 1, b, ans);
        }
        if (b < a) {
            fun(s + ")", n, a, b + 1, ans);
        }
    }
}