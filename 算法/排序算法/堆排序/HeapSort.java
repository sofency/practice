package com.sofency.sort;

import java.util.ArrayList;

/**
 * @auther sofency
 * @date 2020/1/16 13:57
 * @package 堆排序
 */
public class HeapSort {
    //堆排序
    public static <E extends Comparable<E>> void  heapsort(E[] list){
        Heap<E> heap = new Heap<>();
        for(int i=0;i<list.length;i++){
            heap.add(list[i]);
        }
        for(int i=0;i<list.length;i++){
            list[i]=heap.remove();
        }
    }
    public static void main(String[] args) {
        Integer[] array= {2,1,3,5,7,4,2,-1,2,3,4};//大顶堆
        heapsort(array);

        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }


    }


}
//堆类 堆是完全二叉树
class Heap<E extends Comparable<E>>{
    private ArrayList<E> list = new ArrayList<>();
    public Heap(){
    }
    //从数组添加
    public Heap(E[] object){
        for(int i=0;i<object.length;i++){
            add(object[i]);
        }
    }
    public void add(E newObject){
        list.add(newObject);
        int currentIndex = list.size()-1;
        while(currentIndex>0){
            int parentIndex = (currentIndex-1)/2;
            if(list.get(currentIndex).compareTo(list.get(parentIndex))>0){
                E temp= list.get(currentIndex);
                //将父亲的结点和自己的结点交换位置
                list.set(currentIndex,list.get(parentIndex));
                list.set(parentIndex,temp);
            }else{
                break;
            }
            currentIndex=parentIndex;
        }
    }

    //删除根节点之后重新排序
    public E remove(){
        if(list.size()==0) return null;
        E removedObject = list.get(0);//弹出栈顶元素
        list.set(0,list.get(list.size()-1));//将最后一个叶子结点换到栈顶
        list.remove(list.size()-1);//删除最后一个结点
        int currentIndex=0;
        //重新调整成大顶堆
        while(currentIndex<list.size()){
            int leftChildIndex = 2*currentIndex+1;//左孩子
            int rightChildIndex = 2*currentIndex+2;//右孩子
            if(leftChildIndex>=list.size()) break;
            int maxIndex = leftChildIndex;
            if(rightChildIndex<list.size()){//说明还在列表中
                if(list.get(maxIndex).compareTo(list.get(rightChildIndex))<0){
                    maxIndex= rightChildIndex;
                }
            }
            if(list.get(currentIndex).compareTo(list.get(maxIndex))<0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }else{
                break;
            }
        }
        return removedObject;
    }


}