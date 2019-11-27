package com.lh.sort;

import java.util.Arrays;

/**
 * @Description:
 * @author LuoH
 * @date 2019/11/13
 */
public class BubbleSort2 {
    public int[] sort(int[] sourceArray) throws Exception {
        //对arr进行拷贝 不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j  + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        int arr[] = {9, 6, 2, 6, 5, 1, 3};
        for (Integer item : arr) {
            System.out.print(item);
        }
        System.out.println();
        BubbleSort2 bubbleSort = new BubbleSort2();
        int arr2[] = bubbleSort.sort(arr);
        for (Integer item : arr2) {
            System.out.print(item);
        }
    }
}
