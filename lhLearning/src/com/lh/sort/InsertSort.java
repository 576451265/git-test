package com.lh.sort;

/**
 * @Description: 直接插入排序
 * @author LuoH
 * @date 2019/11/4
 */
public class InsertSort {
    static class ArrayIns {
        private long[] A;
        private int nElems;

        public ArrayIns(int max) {
            A = new long[max];
            nElems = 0;
        }

        public void inset(long value) {
            A[nElems] = value;
            nElems++;
        }

        public void display() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(A[j] + "");
            }
            System.out.println();
        }

        //算法书上的正规方法
        public void inserSrot1() {
            int in, out;
            for (out = 1; out < nElems; out++) {
                long temp = A[out];
                in = out;
                while (in > 0 && A[in - 1] >= temp) {
                    A[in] = A[in - 1];
                    in--;
                }
                A[in] = temp;
            }
        }

        //王道上的辣鸡方法
        public void inserSrot2() {
            int i, j;
            for (i = 2; i <= nElems; i++) {
                if (A[i] < A[i - 1]) {
                    A[0] = A[i];
                    for (j = i - 1; A[0] < A[j]; -- j){
                        A[j+1] = A[j];
                    }
                    A[j+1] = A[0];
                }
            }
        }

    }
    public static void main(String[] args) {
        /*
        int maxSize = 8;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        arr.inset(9);
        arr.inset(8);
        arr.inset(7);
        arr.inset(6);
        arr.inset(5);
        arr.inset(4);
        arr.inset(3);
        arr.display();
        arr.inserSrot1();
        arr.display();
        */


        //网上的方法
        int[] array = {6, 5, 4, 3, 2, 1};
        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
        //直接插入排序
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                //前面的数覆盖后面的数
                array[j] = array[j - 1];
                //前面存在多个数的情况下，要插入数需要与前面的数依次进行比较
                j--;
            }
            array[j] = temp;//插入数据
        }

        //折半插入排序
        /*
        for (int i = 1; i<array.length;i++){
            int temp = array[i];
            int low = 0;
            int high = i-1;
            int mid = -1;
            while (low<high){
                mid = (low+high)/2;
                if (array[mid]>temp){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
            for (int j= i-1;j>=low;j--){
                array[j+1] = array[j];
            }
            array[low] = temp;
        }
        */

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }
    }

}

