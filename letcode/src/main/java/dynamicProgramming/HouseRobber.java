package dynamicProgramming;

class HouseRobber {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 构建一个数组, 数组中存储每一步的最优解, 数组要比原数组长度多1, 第0位存储0, 代表最差的收益
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            // dp[2] = max( dp[1] ,  dp[0] + nums[1] )
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }

    public int rob2(int[] nums) {

        // 设置两个值, 分别代表当前的最优解, 以及上一步的最优解
        // 当前最优解
        int curr = 0;
        // 上一步最优解
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(curr, pre + nums[i]);
            pre = curr;
            curr = tmp;
        }

        return curr;
    }
}