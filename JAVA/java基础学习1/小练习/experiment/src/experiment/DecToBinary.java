package experiment;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 十六进制转化为二进制
 * @Version: 1.0
 */
public class DecToBinary {
    public static void main(String[] args) {
        changeTo2(30);
    }

//    public static int changeTo10(char[] arr){
//        int sum=0;
//        for (int i = 0; i < arr.length; i++) {
//            sum=sum*16+arr[i]-'0';
//        }
//        return sum;
//    }

    public static void changeTo2(int num){
        int temp=num%2;
        if(num!=0) {
            changeTo2(num/2);
        }
        else{
            return;
        }
        System.out.print(temp);
    }

}
