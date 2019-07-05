/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试可变字符序列和不可变字符序列使用的陷阱
 * @Version: 1.0
 */
public class testStringBuilder1 {
    public static void main(String[] args) {
        String str1="";
        long num1=Runtime.getRuntime().freeMemory();//获取当前的内存容量
        long time1=System.currentTimeMillis();//获取当前时间
        for(int i=0;i<5000;i++){
            str1=str1+i;//字符串的连接  相当于创建了10000个对象
        }
        long num2=Runtime.getRuntime().freeMemory();
        long time2=System.currentTimeMillis();
        System.out.println("占用内存："+(num1-num2));//获取占用的内存容量
        System.out.println("耗费时间"+(time2-time1));//获取耗费的时间


        StringBuilder str2=new StringBuilder();
        long num3=Runtime.getRuntime().freeMemory();
        long time3=System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            str2.append(i);//添加字符串
        }
        long num4=Runtime.getRuntime().freeMemory();
        long time4=System.currentTimeMillis();
        System.out.println("占用内存："+(num3-num4));//获取占用的内存容量
        System.out.println("耗费时间"+(time4-time3));//获取耗费的时间
    }
}
