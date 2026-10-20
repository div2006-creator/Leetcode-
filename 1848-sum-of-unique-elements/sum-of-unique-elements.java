class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[110];
        for(int num: nums){
            arr[num]++;
        }
        int ans = 0;
          for(int num: nums){
            if(arr[num]==1) ans+=num; 
          }
          return ans;
    }
}