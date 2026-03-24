package dynamicProgramming;


/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class ClimbingStairs {
    public static void main(String[] args) {
//        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int[] cost = {1,100 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int pre2 = 0;
        int pre1 =  Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            // 输入：cost = [10,15,20]
            // 输入：cost = [1,100,1,1,1,100,1,1,100,1]

            int curr = Math.min(pre2 + cost[i - 1], pre1 + cost[i]);
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }
}
