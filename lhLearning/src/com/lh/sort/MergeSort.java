package com.lh.sort;

/**
 * @Description: 归并排序
 * @author LuoH
 * @date 2019/11/12
 */
public class MergeSort {


    public static void merge(int[] array,int low,int mid,int high,int[] tmp){
        int i=0;
        int j =low,k=mid+1;//左边序列和右边序列起始索引
        while (j<=mid && k<=high){
            if (array[j]<array[k]){
                tmp[i++] = array[j++];
            }else {
                tmp[i++] = array[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j<=mid){
            tmp[i++] = array[j++];
        }
        while (k<=high){
            tmp[i++] = array[k++];
        }
        for (int t=0;t<i;t++){
            array[low+t] = tmp[t];
        }
    }
    public static void mergeSort(int[] array,int low,int high,int[] tmp){
        if (low<high){
            int mid = (low+high)/2;
            mergeSort(array,low,mid,tmp);//对左边序列进行归并排序
            mergeSort(array,mid+1,high,tmp);//对右边序列进行归并排序
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
            merge(array,low,mid,high,tmp);//合并两个有序序列
        }
    }

    public static void main(String[] args) {
        int[] array = {11,44,23,67,88,65,34,48,9,12};
        int[] tmp = new int[array.length];
        mergeSort(array,0,array.length-1,tmp);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
