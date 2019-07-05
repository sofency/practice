package csdn;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: csdn
 * @Version: 1.0
 */
public class csdn {
    public static void main(String[] args) {
        XiaoMing xm=new XiaoMing(18,10,"21",0);
        xm.say();
        System.out.println(xm.age);
        xm.Program();
    }
}
class person{
    int age;
    String name;
    int height;
    int weight;
    public void say(){
        System.out.println("我可以说话");
    }
}

class XiaoMing extends person{
    public XiaoMing(int age,int height,String name,int weight){//如果没有上面的类的话，还需要再进行声明
        this.age=age;
        this.name=name;
        this.height=height;
        this.weight=weight;
    }
    public void Program(){
        System.out.println("嫁给我，我敲代码养你！");
    }
}
class XiaoHong extends person{
    public XiaoHong(int age,int height,String name,int weight){//如果没有上面的类的话，还需要再进行声明
        this.age=age;
        this.name=name;
        this.height=height;
        this.weight=weight;
    }
    public void Dancer(){
        System.out.println("我可以跳舞");
    }
}

