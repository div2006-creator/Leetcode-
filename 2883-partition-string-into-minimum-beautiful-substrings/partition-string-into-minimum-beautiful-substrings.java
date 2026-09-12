class Solution {

    public boolean check(int l, int r, String s) {
        if (s.charAt(l) == '0') {
            return false;
        }
        StringBuilder tmp = new StringBuilder();
        for (int i = l; i <= r; i++) {
            tmp.append(s.charAt(i));
        }

        int num = 0;
        for (int i = 0; i < tmp.length(); i++) {
            num = num * 2 + (tmp.charAt(i) - '0');
        }

        for (int k = 0; k <= 12; k++) {
            int c1 = (int) Math.pow(5, k);

            if (num == c1) {
                return true;
            }
        }

        return false;
    }

    public int fun(int p, int i, String s) {
        if (i == s.length() - 1) {
            if (check(p, i, s)) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        int m = Integer.MAX_VALUE;
        if (check(p, i, s)) {

            int a = fun(i + 1, i + 1, s);

            if (a != Integer.MAX_VALUE) {
                a = a + 1;
                m = Math.min(m, a);
            }
        }
        int a = fun(p, i + 1, s);
        m = Math.min(m, a);

        return m;
    }
    public int minimumBeautifulSubstrings(String s) {
        int ans = fun(0, 0, s);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans + 1;
    }
}