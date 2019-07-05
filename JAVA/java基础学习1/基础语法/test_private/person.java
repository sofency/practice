package test_private;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.test_private
 * @Version: 1.0
 */
public class person {
    public static void main(String[] args) {
        test_private p1=new test_private();
        p1.setAge(10);//设置age
        System.out.println(p1.getAge());
        p1.setName("sofency");//设置姓名不然无法操作私有属性
        //p1.age=10;错误:(14, 11) java: age可以在top.sofency.test_private.test_private中访问private
        //System.out.println(p1.age);
        System.out.println(p1.getName());
    }
}
