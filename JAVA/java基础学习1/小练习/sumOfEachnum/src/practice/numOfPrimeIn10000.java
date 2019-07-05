package practice;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class numOfPrimeIn10000 {
    public static void main(String[] args) {
        int count=0;
        for (int i = 2; i < 10000; i++) {
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(10000+"以内有"+count+"个素数!" );
    }
    public static boolean isPrime(int number){
        for (int i = 2; i <=Math.sqrt(number) ; i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
