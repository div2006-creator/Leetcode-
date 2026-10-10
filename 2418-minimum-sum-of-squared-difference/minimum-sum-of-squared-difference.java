class Solution {
public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
int n = nums1.length;
int[] diff = new int[n];
int max = 0;
long k = (long) k1 + k2;

    for (int i = 0; i < n; i++) {
        diff[i] = Math.abs(nums1[i] - nums2[i]);
        max = Math.max(max, diff[i]);
    }
    long total = 0;
    for (int x : diff) {
        total += x;
    }

    if (total <= k) return 0;

    int low = 0;
    int high = max;

    while (low < high) {
        int mid = low + (high - low) / 2;
        long ops = 0;
        for (int x : diff) {
            if (x > mid) {
                ops += x - mid;
            }
        }

        if (ops <= k) high = mid;
        else low = mid + 1;
    }

    int target = low;
    long ans = 0;
    long used = 0;

    for (int x : diff) {
        if (x > target) {
            used += x - target;
            x = target;
        }

        ans += (long) x * x;
    }

    long remaining = k - used;

    for (int i = 0; i < n && remaining > 0; i++) {
        if (diff[i] >= target && target > 0) {
            ans -= (long) target * target;
            ans += (long) (target - 1) * (target - 1);
            remaining--;
        }
    }

    return ans;
}
}