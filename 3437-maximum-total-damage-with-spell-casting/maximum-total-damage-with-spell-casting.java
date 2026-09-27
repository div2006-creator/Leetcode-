class Solution {

    public long maximumTotalDamage(int[] power) {

        Arrays.sort(power);

        ArrayList<Long> val = new ArrayList<>();
        ArrayList<Long> sum = new ArrayList<>();

        int i = 0;

        while (i < power.length) {

            int j = i;
            long total = 0;

            while (j < power.length && power[j] == power[i]) {
                total += power[j];
                j++;
            }

            val.add((long) power[i]);
            sum.add(total);

            i = j;
        }

        long[] dp = new long[val.size()];
        Arrays.fill(dp, -1);

        return solve(0, val, sum, dp);
    }

    long solve(int i, ArrayList<Long> val,
               ArrayList<Long> sum, long[] dp) {

        if (i >= val.size()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        long skip = solve(i + 1, val, sum, dp);

        int next = upperBound(val, val.get(i) + 2);

        long take = sum.get(i) + solve(next, val, sum, dp);

        return dp[i] = Math.max(skip, take);
    }

    int upperBound(ArrayList<Long> val, long target) {

        int l = 0;
        int r = val.size();

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (val.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}