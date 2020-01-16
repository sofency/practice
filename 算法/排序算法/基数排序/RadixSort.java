package com.sofency.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther sofency
 * @date 2020/1/16 21:01
 * @package 基数排序
 */
public class RadixSort {
//    1.给定一数组
//    2.找出最大数的位数
//    3.基数增加进行将数据添加到容器里面
    public static void main(String[] args) {
        int[] array={3,23,41,5,22,1,31,1,6,71};
        List<Integer> list = sortRadix(array);
        System.out.println(list);
    }

    //找到最大的数字
    public static int maxDigit(int[] array){
        if(array.length!=0){
            int maxNum=array[0];
            for(int i=1;i<array.length;i++){
                if(array[i]>maxNum){
                    maxNum=array[i];
                }
            }
            return maxNum;
        }else{
            throw new NullPointerException("数组为空");
        }
    }
    //最多位数
    public static int maxCapacity(int number){
        int cnt=0;
        while(number!=0){
            number=number/10;
            cnt++;
        }
        return cnt;
    }

    //返回数字某一位的位数
    public static int returnNum(int pos,int number){
        int digits = maxCapacity(number);//数字的位数
        int i=0;
        int temp=0;
        while(i<=pos){
            temp=number%10;
            number=number/10;
            i++;
            if(i>digits){
                return 0;
            }
        }
        return temp;
    }

    //基数排序
    public static List<Integer> sortRadix(int[] num){
        List<Integer> list[]= new ArrayList[10];//创建10个容器
        List<Integer> sorted = new ArrayList<>();
        for(int i=0;i<10;i++){//初始化容器
            list[i]= new ArrayList<>();
        }
        int maxnum = maxDigit(num);//最大的数字
        int maxcapacity = maxCapacity(maxnum);//最大的容量

        for(int i=0;i<10;i++){
            int digit = returnNum(0,num[i]);
            list[digit].add(num[i]);
        }//添加到容器里面

        //再操作列表里面的值
        for(int i =1;i<maxcapacity;i++){
            for(int j=0;j<10;j++){
                if(list[j].size()!=0){
                    //再次进行操作列表
                    int cnt=list[j].size();
                    int k=0;
                    while(k<cnt){
                        int temp = list[j].remove(0);//头节点
                        int digit = returnNum(i,temp);
                        list[digit].add(temp);
                        k++;
                    }
                }
            }
        }

        for(int j=0;j<10;j++){
            if(list[j].size()!=0){
              sorted.addAll(list[j]);
            }
        }
        return sorted;
    }
}
