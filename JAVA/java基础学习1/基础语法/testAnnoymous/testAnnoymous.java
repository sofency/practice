package testAnnoymous;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试匿名内部类
 * @Version: 1.0
 */
public class testAnnoymous {
    public static void test01(keyboard key){//keyword是一个接口名
        System.out.println("哈哈哈") ;
        key.click();
    }

    public static void main(String[] args) {
        testAnnoymous.test01(new keyboard() {//匿名内部类
            @Override
            public void click() {
                System.out.println("你敲击了一次");
            }
        });
    }
}
interface keyboard{
    void click();//点击键盘的类
}
