/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class testArrayClass {
    public static void main(String[] args) {
        int[] list={1,3,2,6,5,7,9,4};
        System.out.println("数组排序类");
        java.util.Arrays.sort(list);//会指向数组的名字,该类会对数组进行顶点操作
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }

        System.out.println("\n字符排序");
        char[] chars={'A','a','4','F','D','P'};
        java.util.Arrays.sort(chars);//排序类的调用
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
         System.out.println("\n二分法查找");
        int[] list2={2,4,6,7,9,12,15,47,88,89,90,100};
        System.out.println(" the location of Index 12 is "+java.util.Arrays.binarySearch(list2,12));
    }
}
