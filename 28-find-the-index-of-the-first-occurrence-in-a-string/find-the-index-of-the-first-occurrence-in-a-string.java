class Solution {
public int strStr(String s, String needle) {
for (int i = 0; i <= s.length() - needle.length(); i++) {
if (s.substring(i, i + needle.length()).equals(needle)) {
return i;
}
}
return -1;
}
}
