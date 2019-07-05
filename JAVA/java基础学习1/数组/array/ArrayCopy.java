/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class ArrayCopy {
    public static void main(String[] args) {
        String[] s1={"sofency","alice","ahojcc","robbin"};
        String[] s2=new String[10];
        //srcPos是字符串1的起始下标位置，s2表示从下标开始的位置 length表示复制的长度
        System.arraycopy(s1,1,s2,0,2);

        for (String m:s2) {
            System.out.println(m);
        }
        //删除字符串数组中的alice alice的下标是1，所以要从1的下一位开始的连续两位赋值到s1的1开始的位置
        System.arraycopy(s1,2,s1,1,2);
        s1[s1.length-1]=null;
        for (String m:s1) {
            System.out.println(m);
        }

        //数组的扩容
        String[] s3=new String[s1.length+10];//将s1进行扩容
        System.arraycopy(s1,0,s3,0,s1.length);
        //输出s3\
        for (String m:s3
             ) {
            System.out.println(m);

        }


    }
}
