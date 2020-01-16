package com.sofency.sort;

/**
 * @auther sofency
 * @date 2020/1/16 12:53
 * @package 把所有的排序算法掌握
 */
public class insertSort {
    public static void main(String[] args) {
        int[] array={2,4,1,4,56,7,8};
        sortMethod1(array);
    }
    public static void sortMethod1(int[] array){
        //插入算法的精髓就是找到下一个数比上一个数小的话就插入到合适的位置
        for(int i=1;i<array.length;i++){
            int current= array[i];
            int j;
            for(j=i-1;j>=0&&array[j]>current;j--){//前面的位置一次向后移动
                array[j+1]=array[j];
            }
            array[j+1]=current;
        }
        printArray(array);
    }
    public  static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
