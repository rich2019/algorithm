package algorithm_easy;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * https://leetcode.cn/problems/jBjn9C/
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;

    /**
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     *
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
    }

    /**
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     *
     * @param val
     * @return
     */
    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
