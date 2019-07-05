package test_private;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.test_private
 * @Version: 1.0
 */
public class test_private {
    private int id;
    private String name;
    private int age;
    private boolean man;


    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){//对私有的属性进行封装处理，对用户不暴露如何处理的过程
        if(age>=1&&age<=130){
            this.age=age;
            System.out.println("congratulation！");
        }else{
            System.out.println("请输入正常的年龄！");
        }
    }
    public int getAge(){
        return this.age;
    }
}
