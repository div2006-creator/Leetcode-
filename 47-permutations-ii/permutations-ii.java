class Solution {

    void fun(int[] nums, boolean[] visited,
             List<Integer> op, List<List<Integer>> ans) {

        if (op.size() == nums.length) {
            ans.add(new ArrayList<>(op));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            op.add(nums[i]);

            fun(nums, visited, op, ans);

            op.remove(op.size() - 1);
            visited[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<Integer> op = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        fun(nums, visited, op, ans);

        return ans;
    }
}