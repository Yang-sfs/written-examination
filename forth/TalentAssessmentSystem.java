package Code.forth;

/*
 * 通过对数组同时进行二分查找，当较短数组查找结束时，整个查找结束，时间复杂度为 O(log( min(n, m) ))
 * 空间上只使用了常数个空间来存储临时变量，空间复杂度为 O(1)
 * 
 * 进阶挑战：
 * 1.为每一个学徒维护一个最大堆和一个最小堆，分别存储一半元素。最大堆存储较小的一半元素，堆顶是这部分中的最大值；最小堆存储较大的一半元素，堆顶是这部分中的最小值。
 * 中位数根据两个堆的大小决定：1. 如果两个堆的大小相同，中位数是两个堆顶元素的平均值；2. 如果一个堆的元素比另一个堆多1个，则中位数是那个堆的堆顶元素。
 * 
 * 2.将K个数组进行递归式二分合并，再使用原算法进行中位数查找
 */

public class TalentAssessmentSystem {

    private static double FindElementOfIndexK(int[] fireAbility, int[] iceAbility, int k) {
        int idx1 = 0, idx2 = 0, len1 = fireAbility.length, len2 = iceAbility.length;
        while (true) {
            if (idx1 == len1) {
                return iceAbility[idx2 + k];
            }
            if (idx2 == len2) {
                return fireAbility[idx1 + k];
            }
            if (k == 1) {
                return Math.min(fireAbility[idx1], iceAbility[idx2]);
            }
            idx1 = Math.min(len1 - 1, idx1 + k / 2 - 1);
            idx2 = Math.min(len2 - 1, idx2 + k / 2 - 1);
            if (fireAbility[idx1] < iceAbility[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
            k -= k / 2;
        }
    }

    public static double FindMedianTalentIndex(int[] fireAbility, int[] iceAbility) {
        int totalLength = fireAbility.length + iceAbility.length;
        if (totalLength % 2 == 1) {
            return FindElementOfIndexK(fireAbility, iceAbility, totalLength / 2);
        } else {
            return (FindElementOfIndexK(fireAbility, iceAbility, totalLength / 2)
                    + FindElementOfIndexK(fireAbility, iceAbility, totalLength / 2 - 1)) / 2.0;
        }
    }

}
