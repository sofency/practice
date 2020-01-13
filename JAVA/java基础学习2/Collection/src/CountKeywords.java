import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @auther sofency
 * @date 2020/1/13 20:35
 * @package PACKAGE_NAME
 */
public class CountKeywords {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a java source file:");
//        H:\JAVA\Collection\src\demo.txt
        String filename = input.nextLine();
        File file  = new File(filename);
        if(file.exists()){
            System.out.println("the number of the keywords in"+filename+" is "+countKeywords(file));
        }else {
            System.out.println(0);
        }
    }
    public static int countKeywords(File file) throws FileNotFoundException {
        String[] keywords={"if","else","while","and" ,"or","instanceof","void","static","public","private","final","finally","catch","try","int","float","char"};
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        int count =0;
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            String word = scan.next();
            System.out.println(word);
            if(set.contains(word)){
                count++;
            }
        }
        return count;
    }
}
