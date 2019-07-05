package package1;

/**
 * @Auther: sofency
 * @Date: ${DATA}
 * @Description: package1
 * @Version: 1.0
 */
public class TestRandomCharacter {
    public static void main(String[] args){
        final int NUMBER_OF_CHARS=175;
        final int CHARS_PER_LINE=25;
        RandomCharacter RC=new RandomCharacter();
        for(int i=0;i<NUMBER_OF_CHARS;i++){
            char ch=RC.getRandomLowerCaseLetter('a','z');
            if((i+1)%CHARS_PER_LINE==0)
                System.out.println(ch);
            else
                System.out.print(ch);
        }
    }
}
