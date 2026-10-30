class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        fun(1, n, k, new ArrayList<>());
        return ans;
    }

    public void fun(int i, int n, int k, List<Integer> temp) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j <= n; j++) {
            temp.add(j);

            fun(j + 1, n, k, temp);

            temp.remove(temp.size() - 1);
        }
    }
}