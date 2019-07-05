/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class ArraySort {
    public static void ArraySort(double[] list) {
        for (int i = 0; i < list.length-1; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {//向数组后面的元素进行查找最小值
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;//记录最小值得下标
                }
            }

            if (currentMinIndex != i) {//说明上面的循环运行了，不然上面的if语句就没有运行
                list[currentMinIndex] = list[i];//将第i个元素赋值个找到的最小值的下标
                list[i] = currentMin;//将找到的最小值放到第i位
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
    }
}
