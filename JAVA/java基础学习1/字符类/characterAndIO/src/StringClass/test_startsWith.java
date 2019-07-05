package StringClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
public class test_startsWith {
    public static void main(String[] args) {
        String s1="Welcome to China";
        String s2="welcome to JAVA";
        System.out.println(s1.startsWith("We"));//返回true说明该字串是以We开始的
        System.out.println(s1.startsWith("hello"));//返回false说明不是以hello结束的
        System.out.println(s1.endsWith("China"));//返回true说明s1字符串是以China结束的
        System.out.println(s1.endsWith("china"));//返回false说明不是以china结束的

        System.out.println(s1.regionMatches(8,"to",0,2));(toffect,other,ooffset,len)
        //toffset指明s1字符串中字串的位置下标,other表示比较的字符串,ooffset表示新比较的字符串中的字串开始比较的下表，len 表示比较的下标,
        System.out.println(s1.regionMatches(false,0,s2,0,7));//和s2进行比较 false 表示比较的字串忽略大小写
    }
}
