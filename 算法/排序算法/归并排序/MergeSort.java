package com.sofency.sort;

/**
 * @auther sofency
 * @date 2020/1/16 13:32
 * @package 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array={2,4,1,4,56,7,8};
        mergeSort(array);
        printArray(array);

    }
    public static void mergeSort(int[] array){
        if(array.length>1){
            int[] firstHalf=new int[array.length/2];
            System.arraycopy(array,0,firstHalf,0,array.length/2);
            mergeSort(firstHalf);//分治的方法

            int secondHalfLength= array.length-array.length/2;
            int[] secondHalf =new  int[secondHalfLength];
            System.arraycopy(array,array.length/2,secondHalf,0,secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf,secondHalf,array);
        }
    }
    //合并两个有序的数组列表
    public static void merge(int[] list1,int[] list2,int[] temp){
        int current1=0;
        int current2=0;
        int current3=0;
        while(current1<list1.length&&current2<list2.length){
            if(list1[current1]<list2[current2]){
                temp[current3++]=list1[current1++];
            }else{
                temp[current3++]= list2[current2++];
            }
        }
        while(current1<list1.length){
            temp[current3++]= list1[current1++];
        }
        while(current2<list2.length){
            temp[current3++]= list2[current2++];
        }
    }
    public  static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
