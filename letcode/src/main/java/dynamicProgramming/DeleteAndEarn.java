package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/delete-and-earn/?envType=study-plan-v2&envId=dynamic-programming
 * <p>
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        int data = deleteAndEarn(nums);
        System.out.println(data);

    }

    public static int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            Integer key = num;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
                list.add(key);
            }
        }
        int[] arr = new int[list.size()];
        int num = 0;
        for (Integer sortData : list) {
            arr[num] = sortData;
            num++;
        }

        int pre1 = Math.max(arr[0], arr[1]);
        int pre2 = 0;
        int curr = 0;
        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(pre2 + arr[i] * map.get(arr[i]), pre1);
            pre2 = pre1;
            pre1 = curr;
        }

        return curr;
    }
}