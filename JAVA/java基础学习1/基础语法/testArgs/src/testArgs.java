/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试不定参数
 * @Version: 1.0
 */
public class testArgs {
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5));
        System.out.println(sum(21,3,4));
        System.out.println(sum(91,18,19));
    }
    //没看错就是省略号，解决参数不确定的情况
    public static int sum(int ... a){
        int ret=0;
        for(int num:a){
            ret+=num;
        }
        return ret;
    }
}
