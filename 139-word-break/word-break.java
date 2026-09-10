class Solution {

    Map<String, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Boolean> map = new HashMap<>();

        for (String word : wordDict) {
            map.put(word, true);
        }

        dp.clear();

        return fun(s, 0, "", map);
    }

    public boolean fun(String s, int i, String tmp, Map<String, Boolean> map) {

        if (i == s.length()) {
            return tmp.isEmpty();
        }
        String key = i + "+" + tmp;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        tmp = tmp + s.charAt(i);
        boolean ans = false;
        if (map.containsKey(tmp)) {
            if (fun(s, i + 1, "", map)) {
                ans = true;
            }
        }
        if (fun(s, i + 1, tmp, map)) {
            ans = true;
        }

        dp.put(key, ans);

        return ans;
    }
}