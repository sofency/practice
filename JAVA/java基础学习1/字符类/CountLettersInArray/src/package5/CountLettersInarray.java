package package5;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: package5
 * @Version: 1.0
 */
//不能用public
class CountLettersInArray {
    public static void main(String[] args) {
        char[] chars=createArray();
        System.out.println("the lowercase letters are: ");
        displayArray(chars);
        int[] counts=countLetters(chars);
        System.out.println();
        System.out.println("the occurrences of each letter are:");
        displayCounts(counts);
    }
    //create random character letter
    public static char[] createArray(){
        char[] chars=new char[100];
        for (int i = 0; i < chars.length; i++) {
            chars[i]=RandomCharacter.getRandomLowerCaseLetter();
        }
        return chars;
    }
//display random character of 100
    public static void displayArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if((i+1)%20==0){
                System.out.println(chars[i]);
            }
            else{
                System.out.print(chars[i]+" ");
            }
        }
    }
    //count the occurrences of each letter
    public static int[] countLetters(char[] chars){
        int[] counts=new int[26];//counts是记录26个英文字母重复次数的数组
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;//记录次数
        }
        return counts;//返回数组
    }
///display counts
    public static void displayCounts(int[] counts) {
        for (int i = 0; i < counts.length; i++) {//counts.length是26
            if((i+1)%10==0){
                System.out.println(counts[i]+" "+(char)(i+'a'));
            }
            else{
                System.out.print(counts[i]+" "+(char)(i+'a')+" ");
            }
        }

    }
}
