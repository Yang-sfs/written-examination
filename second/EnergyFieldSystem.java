
/*
 * 通过双指针进行高度数组遍历，时间复杂度为 O(n)
 * 使用了常数级别的额外空间，空间复杂度为 O(1);
 * 
 * 进阶挑战：
 * 1. 在遍历高度数组的同时分别计算：1. 不使用道具的面积，2. 左塔使用道具后的面积，3. 右塔使用道具后的面积，记录下最大的面积
 * 2. 遍历过程中如果某一位置的高度为0，则跳过该位置并将指针移向下一个
 * 
 * 创意思考：
 * 玩家在决策过程中需要考虑塔的高度和距离。
 * 可以考虑塔防游戏，敌人在通过能量场的时候会受到持续伤害，伤害大小与能量场强度相关
 */

public class EnergyFieldSystem {

    public static float MaxEnergyField(int[] heights) {
        int n = heights.length, left = 0, right = n - 1;
        float maxArea = 0f;
        while (left < right) {
            int leftHeight = heights[left], rightHeight = heights[right];
            maxArea = Math.max(maxArea, (float)(leftHeight + rightHeight) * (right - left) / 2);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
}