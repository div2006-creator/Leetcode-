class Solution {
    int dp[][];
    public int longestCommonSubsequence(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int i = 0; i < s.length(); i++) {
        Arrays.fill(dp[i], -1);
        }
        return fun(s, t, 0, 0);
    }
    public int fun(String s, String t, int i, int j) {
        if(i == s.length() || j == t.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)) {
            return 1 + fun(s,t, i + 1, j + 1);
        }
        int c1 = fun(s,t,i + 1, j);
        int c2 = fun(s,t,i, j + 1);
        return dp[i][j] = Math.max(c1, c2);
    }
}


