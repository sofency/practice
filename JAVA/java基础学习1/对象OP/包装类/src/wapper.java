/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class wapper {
    public static void main(String[] args) {
        //基本数据类型转化为包装类
        Integer  a=new Integer(3);
        Integer b=Integer.valueOf(10);

        //将包装类转化为基本数据类型
        int c=b.intValue();
        double d=b.doubleValue();

        //将字符串转化为包装类对象
        Integer e=new Integer("9999");
        Integer f=Integer.valueOf("9189191");

        //将包装类转化为字符串
        String str=f.toString();


        //打印整数的最大值
        System.out.println(Integer.MAX_VALUE);

    }
}
