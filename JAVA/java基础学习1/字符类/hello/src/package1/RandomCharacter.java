package package1;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: package1
 * @Version: 1.0
 */
public class RandomCharacter {
    public static char getRandomLowerCaseLetter(char ch1,char ch2){
        return (char)(ch1+Math.random()*(ch2-ch1+1));
    }
}
