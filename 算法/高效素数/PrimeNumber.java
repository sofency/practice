import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @auther sofency
 * @date 2020/1/13 21:53
 * @package 最高效素数的求法
 */
public class PrimeNumber {
    public static void method1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("find all prime numbers");
        int  n = scanner.nextInt();//获取上限的值

        List<Integer> list = new ArrayList<>();
        final int NUMBER_PER_LINE=10;
        int count =0;
        int number = 2;
        int squareRoot = 1;
        System.out.println("the prime numbers are ");

        while(number<n){
            boolean isPrime = true;
            if(squareRoot*squareRoot<number){//36-49之间的数字平方根还是6近似值还是
                squareRoot++;
            }
            for(int k=0;k<list.size()&&list.get(k)<=squareRoot;k++){//对于9-16之间来说此时squareRoot=4  list集合存储的是2  3 5 7
                if(number%list.get(k)==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                count++;
                list.add(number);//只存储素数
                if(count%NUMBER_PER_LINE==0){
                    System.out.println(number);
                }else{
                    System.out.print(number+" ");
                }
            }
            number++;
        }
    }

    public static void method2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find all prime numbers <=n enter n:");
        int n = scanner.nextInt();
        boolean[] primes = new boolean[n+1];
        for(int i=0;i<primes.length;i++){
            primes[i]=true;
        }
        for(int k=2;k<=n/k;k++){
            for(int i=k;i<=n/k;i++){
                primes[k*i]=false;
            }
        }
        int count=0;
        for(int i=2;i<primes.length;i++){
            if(primes[i]){
                count++;
                if(count%10==0){
                    System.out.println(i);
                }else{
                    System.out.print(i+" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        method2();
    }
}
