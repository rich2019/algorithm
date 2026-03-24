package test;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 2 , 12, 1, 3, 46, 5, 0, -3, 12, 35, 16 };
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
//		quickSort(arr, 0, arr.length-1);
//		partition(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr,low,high);

    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            //获取到分区界限索引
            int index = partition(arr,low,high);
            //对左边进行排序
            quickSort(arr,low,index - 1);
            //对右边进行排序
            quickSort(arr,index + 1,high);

        }
    }

    /**
     * 对数组进行二分排序,并返回分区界限的索引值
     * @param arr
     * @param low
     * @param high
     * @return index
     */
    private static int partition(int[] arr, int low, int high) {
        int i = low;	//左指针
        int j = high;	//右指针
        int x = arr[low];	//将第一个数作为基数值

        while(i < j) {
            //将j指针左移,判断当前值是否小于基数值
            while(arr[j] >= x && i < j) {
                j--;
            }
            //将基数值与j的值交换位置
            if(i < j) {
                arr[i] = arr[j];
                i++;
            }

            while(arr[i] <= x && i < j) {
                i++;
            }
            if(i < j) {
                arr[j] = arr[i];
                j--;
            }


        }
        arr[i] = x;
        return i;
    }

}
