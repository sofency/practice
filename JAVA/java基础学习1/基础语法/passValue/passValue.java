package passValue;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: passValue
 * @Version: 1.0
 */
public class passValue {
    int id;
    String name;
    String pwd;

    public passValue(int id,String name){
        this.id=id;//this表示该类创建的对象
        this.name=name;
    }

    public void testPassValue(passValue pV){
        pV.name="Sofency";
    }

    public void testPassValue1(passValue pv){
        pv =new passValue(100,"alice");
    }
    public static void main(String[] args){
        passValue pv=new passValue(101,"hello");
        pv.testPassValue(pv);//将自己穿进去进行修改
        System.out.println(pv.name);//显示Sofency证明已经修改过

        pv.testPassValue1(pv);
        //pv新创建的对象地址发生变化，所以所以不能改变原来指针指的内容
        //testPassValue1在新建的对象后地址指向发生变化，但仍未改变原来pv的指向
        //java值传递是通过复制进行传递的，复制之后的两个pv都是指向一个对象的
        System.out.println(pv.name);//显示hello//新建的对象
    }
}
