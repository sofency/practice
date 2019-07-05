/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
 public class Examples {
        String name;//不能被主类所访问到 但能被对象所访问到
        static String country;
        static  void print(){
            //static name;局部变量无法被修饰
            System.out.println("你好"+country);
        }
        void print1(){
            System.out.println("你好"+name);
        }
}
