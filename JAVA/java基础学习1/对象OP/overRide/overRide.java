package overRide;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: overRide
 * @Version: 1.0
 */
public class overRide {
    public static void main(String[] args) {
        Horse horse =new Horse();
        horse.run();
        horse.stop();
    }
}
class Vehicle{
    public void run(){
        System.out.println("跑...");
    }
    public void stop(){
        System.out.println("停止");
    }

}

class Horse extends Vehicle{
    public void run(){//更改方法，注意方法名和参数列表相同，
        System.out.println("不跑...");
    }
}

//方法重写注意事项
/*1."==",方法名，形参列表相同
"<="返回值类型和声明异常类型，子类小于父类
">=":访问权限，子类大于父类
* */