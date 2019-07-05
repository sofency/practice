/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {12, 3, 11, 45, 3, 23, 4, 6, 0};
//        array=Bubblesort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+" ");
//        }
        quickSort(array,0,8);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
    public static int[] Bubblesort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean flag=true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                        flag=false;
                }
            }
            if(flag){//可能之前的一部分已经排序好了
                break;
            }
        }
        return arr;
    }
    public static void quickSort(int[] arr,int low,int high){//说明在内部发生转化的值数组原来的值也发生变化
        int key=arr[low];//将第一个数字设置为关键字
        int i=low,j=high;
        if(low>=high) return;

        while(low<high){
            while(arr[high]>=key&&low<high){
                high--;
            }
            if(arr[high]<key){
                int temp=arr[high];
                arr[high]=arr[low];
                arr[low]=temp;
                low++;
            }
            while(arr[low]<=key&&low<high){
                low++;
            }
            if(arr[low]>key) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        quickSort(arr,i,low-1);
        quickSort(arr,low+1,j);
    }
}
