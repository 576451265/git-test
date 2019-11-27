package com.lh.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 简单选择排序
 * @author LuoH
 * @date 2019/11/5
 */
public class SampleSelectSort {
    public static void sampleSelectSort(int[] A) {
        int i, j, length;
        int p = 1;//记录第n次的排序
        int min;//将当前的i暂定为最小的数的位置
        int temp;//用于交换
        length = A.length;
        for (i = 0; i < length; i++) {
            min = i;
            for (j = i + 1; j < length; j++) {
                if (A[min] > A[j]) {
                    min = j;////把较小的数放到前面，但是目前仍未进行交换，因为还没有找出最小的那个数
                }
            }
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
            //输出每次排序结果
            System.out.println("第" + (p++) + "次");
            System.out.println(Arrays.toString(A));
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 3, 9, 10, 8, 6, 1, 4};
        System.out.println(Arrays.toString(arr));
        sampleSelectSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

    }
}
