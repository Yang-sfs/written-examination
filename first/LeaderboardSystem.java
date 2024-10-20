import java.util.ArrayList;
import java.util.List;

/*
 * 使用归并排序进行分数数组排序，排序的时间复杂度为 O(nlogn)，获取前 m 个元素的时间复杂度为 O(m)，但 m <= n，所以
 * 总的时间复杂度为 O(nlogn)
 * 
 * 进阶思考：
 * 如果用户数量过多，可以维护一个大小为 m 的最小堆，随后遍历分数数组，对于每个分数：
 *   1. 如果堆大小小于 m ，将分数入堆，调整堆
 *   2. 如果堆大小大于 m：
 *     1. 如果分数大于堆顶分数，替换堆顶分数，调整堆
 *     2. 如果分数小于堆顶分数，跳过该分数
 * 遍历完毕后把最小堆里的元素取出并逆序，即为所求
 * 
 * 对于一个大小为 m 的最小堆，调整堆的时间复杂度为 O(logm)，总的时间复杂度是 O(nlogm) <= O(nlogn) (m <= n)
 */

public class LeaderboardSystem {

    private static void MergeSort(int[] scores, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        MergeSort(scores, start, mid);
        MergeSort(scores, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= end) {
            if (scores[p1] > scores[p2]) {
                temp[p++] = scores[p1++];
            } else {
                temp[p++] = scores[p2++];
            }
        }
        while (p1 <= mid) {
            temp[p++] = scores[p1++];
        }
        while (p2 <= end) {
            temp[p++] = scores[p2++];
        }
        for (int i = 0; i < p; i++) {
            scores[start + i] = temp[i];
        }
        
    }

    public static List<Integer> GetTopScores(int[] scores, int m) {
        List<Integer> scoreList = new ArrayList<Integer>();
        MergeSort(scores, 0, scores.length - 1);
        m = Math.min(m, scores.length);
        for (int i = 0; i < m; i++) {
            scoreList.add(scores[i]);
        }
        return scoreList;
    }
}