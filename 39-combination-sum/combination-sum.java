//                               Take or not take solution

// class Solution {
//     public void solve(int i, int[] candidates, int target,
//     List<Integer> current,
//     List<List<Integer>> ans) {

//         if (target == 0) {
//             ans.add(new ArrayList<>(current));
//              return;
//         }
//         if (i >= candidates.length || target < 0) {
//             return;
//         }
//         if (candidates[i] <= target) {
//             current.add(candidates[i]);
//             solve(i, candidates, target - candidates[i], current, ans);
//             current.remove(current.size() - 1);
//         }
//         solve(i + 1, candidates, target, current, ans);
//     }
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         solve(0, candidates, target, new ArrayList<>(), ans);
//         return ans;
//     }
// }

//                              using input output approach
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
//         solve(0, candidates, target, current, ans);
//         return ans;
//     }
//     public void solve(int i, int[] candidates, int target,
//      List<Integer> current,
//      List<List<Integer>> ans) {

//         if (target == 0) {
//             ans.add(new ArrayList<>(current));
//             return;
//         }
//         if (i >= candidates.length || target < 0) {
//             return;
//         }
//         for (int j = i; j < candidates.length; j++) {

//             if (candidates[j] > target) {
//                 continue;
//             }
//             current.add(candidates[j]);
//             solve(j, candidates, target - candidates[j], current, ans);

//             current.remove(current.size() - 1);
//         }
//     }
// }

// //                                   using hashmap
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Map<List<Integer>, Boolean> map = new HashMap<>();

        solve(0, candidates, target, current, ans, map);

        return ans;
    }
    public void solve(int i, int[] candidates, int target,
    List<Integer> current,
    List<List<Integer>> ans,
    Map<List<Integer>, Boolean> map) {

        if (target == 0) {
            List<Integer> temp = new ArrayList<>(current);

            if (!map.containsKey(temp)) {
                ans.add(temp);
                map.put(temp, true);
            }
            return;
        }
        if (i >= candidates.length || target < 0) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {

            if (candidates[j] > target) {
                continue;
            }
            current.add(candidates[j]);

            solve(j, candidates, target - candidates[j], current, ans, map);
            current.remove(current.size() - 1);
        }
    }
}