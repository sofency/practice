package testInterface;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 面向接口编程
 * @Version: 1.0
 */
public class testInterface {
    public static void main(String[] args){
        Angel a=new Angel();
        a.fly();
        a.HelpOther();
        System.out.println();

        Volant v=new Angel();//通过接口进行编程通过接口呢进行调用，而不是通过类进行调用
        v.fly();
        //v只认识接口类型
    }
}
/**
 * 飞行接口
 * @author: sofency
 */
interface Volant{
    int FLY_HEIGHT=1000;
    void fly();
}
interface Honest{
    void HelpOther();
}
interface he extends Volant,Honest{//接口的继承
    void sex();
}


class Angel implements Volant,Honest{//实现类可以多个子类接口

    @Override
    public void fly() {
        System.out.println("Angel.helpOther");
    }

    @Override
    public void HelpOther() {
        System.out.println("Angel.help");
    }
}
class Angels implements he{

    @Override
    public void fly() {

    }

    @Override
    public void HelpOther() {

    }

    @Override
    public void sex() {

    }
}


class GoodMan implements Honest{//单接口

    @Override
    public void HelpOther() {
        System.out.println("好男人帮助别人");
    }
}