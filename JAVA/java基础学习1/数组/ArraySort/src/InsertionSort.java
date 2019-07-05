/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class InsertionSort {
    public static void insertionSort(double[] list) {
        for (int i = 1; i <list.length ; i++) {
            double currentElement=list[i];//记录当前的元素
            int k;
            for (k = i-1; k >=0&&list[k]>currentElement; k--) {//拆成两个数组
                list[k+1]=list[k];//将大于当前元素的数据向后移动
            }
            list[k+1]=currentElement;
        }
        for (int i = 0; i <list.length ; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
