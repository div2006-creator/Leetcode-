// class Solution {
//     public int change(int amount, int[] coins) {
//         return  solve(0,amount,coins);
//     }
       
//    int solve(int index, int amount,int[] coins){
//         if(amount == 0) { 
//             return 1;
//         }
//         if(amount < 0 || index == coins.length) {
//             return 0;
//         }
//     Arrays.fill()
//         int c1 = solve(index,amount - coins[index], coins);
//         int c2 = solve(index + 1,amount, coins);
     
//         return c1 + c2;

//     }
//}


class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, amount, coins, dp);
    }
    int solve(int index, int amount, int[] coins, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || index == coins.length) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int c1 = solve(index, amount - coins[index], coins, dp);
        int c2 = solve(index + 1, amount, coins, dp);

        return dp[index][amount] = c1 + c2;
    }
}
