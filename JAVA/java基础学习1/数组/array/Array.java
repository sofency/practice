/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;//导入工具类
public class Array {

    //testBinarySearch
    public static void main(String[] args) {

        int[] array=new int[10];
        Scanner input=new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i]=input.nextInt();//输入值
        }
       //排序函数
        Arrays.sort(array);
        //Arrays.toString(数组名)返回数组的内容
        System.out.println(Arrays.toString(array));
        //二分查找key为6的下标
        int a=Arrays.binarySearch(array,6);
        System.out.println(a);
        //test asList()
        String[] s={"alice","sofency","ahoj"};
       List<String> s1=Arrays.asList("alice","sofency","ahoj");
        for (String str:s1
             ) {
            System.out.println(str);
        }
    }
}
