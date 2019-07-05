/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class twoArray {
    public static void main(String[] args) {
        int[] array=new int[10];
        array[0]=10;
        int[][] a= new int[3][];//标记该数组对象存储3个一维数组对象
        a[0]=new int[]{1,2,3,4};
        a[1]=new int[]{20,30,2};
        a[2]=new int[]{01,02};
        System.out.println(a[0][3]);
        //System.out.println(a[1][3]);//异常 说明java的多维数组每行可以设置不同的长度

    }
}
