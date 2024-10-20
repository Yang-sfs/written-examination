package Code.third;

/*
 * 算法遍历了一遍数组，时间复杂度为 O(n)
 * 空间上只使用了dp0, dp1, dp2，常数个额外空间，空间复杂度为 O(1)
 * 
 * 进阶挑战：
 * 1. 修改动态规划的状态，dp[i][0] 表示在[0, i]范围内，不使用魔法钥匙的情况下能获得的最大价值；dp[i][1] 表示在[0, i]范围内，使用魔法钥匙的情况下能获得的最大价值。状态转移方程变为：
 * dp[i][0] = max(dp[i-1][0], dp[i-2][0] + treasures[i])；
 * dp[i][1] = max(dp[i-1][1], dp[i-2][1] + treasures[i]) (魔法钥匙已经被使用过了)
 *            max(dp[i][1], dp[i-2][0] + treasures[i-1] + treasures[i]) (魔法钥匙没有被使用过)
 * 
 * 2.原算法能够处理负数情况，如果当前打开的宝箱为负值，dp[i] = max(dp[i-1], dp[i-2] + treasures[i]), 此时dp[i]=dp[i-1]，表示[0, i-1]范围内的最大价值，符合条件
 */

public class TreasureHuntSystem {

    public static int MaxTreasureValue(int[] treasures) {
        int n = treasures.length;
        if (n == 0) return 0;
        if (n == 1) return treasures[0];
        int dp0 = treasures[0], dp1 = Math.max(treasures[0], treasures[1]);
        for (int i = 2; i < n; i++) {
            int dp2 = Math.max(dp1, dp0 + treasures[i]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp1;
    }

}