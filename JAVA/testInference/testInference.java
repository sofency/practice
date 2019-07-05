package testInference;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: testInference
 * @Version: 1.0
 */
public interface testInference {
    int maxAge=100;//默认前面有public static final
    void test01();//接口就是类与类之间沟通的桥梁，
    // 接口类中没有实现的方法全部是抽象的方法
    // 默认有public abstract

}
class MyClass implements testInference{

    @Override//里面写实现的方法
    public void test01() {
        //TODO
        System.out.println("my first interface");
    }
}
