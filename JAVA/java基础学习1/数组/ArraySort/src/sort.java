/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class sort {
    public static void main(String[] args) {
        double[] list={1,9,4.5,6.6,5.7,-4.5};
        System.out.println("选择排序");
        ArraySort.ArraySort(list);//调用ArraySort的类
        System.out.println("\n插入法排序");
        InsertionSort.insertionSort(list);//调用InsertionSort类
    }
}
