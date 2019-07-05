package study;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: study
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        int number1=10;
        int number2=20;
        test Max=new test();
        if(Max.max(number1,number2)){
            System.out.println(number1+" 大于 "+number2);
        }
        else
            System.out.println(number1+" 小于 "+number2);

    }
    public boolean max(int number1,int number2){
        if(number1>number2){
            return true;
        }
        else
            return false;
    }
}
