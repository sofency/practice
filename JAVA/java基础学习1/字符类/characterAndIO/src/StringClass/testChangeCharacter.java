package StringClass;
/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
public class testChangeCharacter {
    public static void main(String[] args) {
        String s1="Hello World";
        System.out.println(s1.toLowerCase());//转化为小写
        System.out.println(s1.toUpperCase());//转化为大写
        System.out.println(s1.replace('o','O'));//取代所有的字符 o
        System.out.println(s1.replaceFirst("o", "O"));//必须双引号

        String[] s2="hello#world".split("#",0);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }

        String[] s3="my#name#is#sofency#".split("#",-1);//是通过特定的符号将字符串分割为字符数组
        System.out.println(s3.length);//limit=-1时的用法就是存在多少个分割符就将字符串分割为多少个子串
        //复习参考网址https://blog.csdn.net/hepann44

        for (int i = 0; i < s3.length; i++) {
            System.out.print(s3[i]+",");
        }
    }
}
