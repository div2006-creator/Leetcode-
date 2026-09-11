class Solution {
    int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return fun(0, days, costs);
    }

    int fun(int i, int[] days, int[] costs) {
        if (i >= days.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int curr = days[i];

        int c1 = days.length;
         int c2 = days.length;

        for (int j = i + 1; j < days.length; j++) {
            if (days[j] >= curr + 7) {
                c1 = j;
                break;
            }
        }

        for (int j = i + 1; j < days.length; j++) {
            if (days[j] >= curr + 30) {
                c2 = j;
                break;
            }
        }

        int one = costs[0] + fun(i + 1, days, costs);
        int seven = costs[1] + fun(c1, days, costs);
        int thirty = costs[2] + fun(c2, days, costs);

        return dp[i] = Math.min(one, Math.min(seven, thirty));
    }
}