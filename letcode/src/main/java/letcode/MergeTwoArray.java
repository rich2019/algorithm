package letcode;

/**
 * 两个有序数组合并
 */
class MergeTwoArray {

    public static void main(String[] args) {
        //[1,2,3,0,0,0]
        //3
        //[2,5,6]
        //3
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{1};
        merge(num1, 0, num2, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }
    }

 
}
