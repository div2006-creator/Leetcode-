class Solution {
public int longestPalindrome(String s) {
int[] arr = new int[128];
    for (char c : s.toCharArray()) {
        arr[c]++;
    }
    int ans = 0;
    for (int i = 0; i < 128; i++) {
        ans += (arr[i] / 2) * 2;
    }
    if (ans < s.length()) ans++;
    return ans;
}
}
