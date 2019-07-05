/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class RandomCharacter {
    public static void main(String[] args) {
        int i=0;
        do {
            int number=(int)(Math.random()*26+65);
            char character=(char)number;
            System.out.print(character+" ");
            i++;
        }while(i<100);
    }
}
