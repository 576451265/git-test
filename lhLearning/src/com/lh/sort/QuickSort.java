package com.lh.sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @author LuoH
 * @date 2019/11/5
 */
public class QuickSort {
    /*public static void quickSort(int[] array, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = array[low];
        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= array[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= array[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = array[j];
                array[j] = array[i];
                array[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        array[low] = array[i];
        array[i] = temp;
        //递归调用左半数组
        quickSort(array, low, j - 1);
        //递归调用右半数组
        quickSort(array, j + 1, high);
    }
    public static void main(String[] args) {
        int[] array = {1, 7, 2, 4, 6, 3, 5, 8, 9};
        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i);
        }
    }*/

    //    法二
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 7, 3, 9, 10, 8, 6, 1, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //排序方法-假设从小到大排序
    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            //递归调用
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
    }

    //划分方法
    private static int partition(Integer[] arr, int low, int high) {
        //使用 r[low]作为枢轴元素
        int pivot = arr[low];
        //从两端交替向内扫描
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            //将比 pivot 小的元素移向低端
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            //将比 pivot 大的元素移向高端
            arr[high] = arr[low];
        }
        //设置枢轴
        arr[low] = pivot;
        //返回枢轴元素位置
        return low;
    }
}