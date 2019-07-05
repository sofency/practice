/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试字符串类的相关方法
 * @Version: 1.0
 */
public class CharacterClass {
    public static void main(String[] args) {
        String newString= new String("wellcome to my github");
        //测试charAt 返回指定下标的字符
        char num=newString.charAt(2);
        System.out.println(num);
        //concat 返回连接两个字符串的新字符串
        String newString1=new String(" and blog");
        System.out.println(newString.concat(newString1));
        //字符串的加法
        String s=newString+newString1;
        System.out.println(s);
        //获取子字符串
        System.out.println(newString.substring(2));//起始位置-最后
        System.out.println(newString.substring(2,6));//起始位置-结束位置
        System.out.println(newString.regionMatches(9,"to",0,2));
        //将数值和字符转化为字符串用来处理比较大的数字
        int number=10000;
        System.out.println(String.valueOf(number));
        System.out.println(String.valueOf(number).getClass().toString());//判断在哪个类中的方法
        System.out.println(String.valueOf(number)instanceof String);//true 表示是String类型的
        //格式化字符串
        String str=String.format("%5.2f",12.3345);//5表示5位包括字符 . 2代表小数位数
        System.out.println(str);

        //包装类
        //字符类的操作函数

        Character character=new Character('A');
        System.out.println(character.charValue());//返回字符的值A

        System.out.println(character.compareTo('a'));//字符在ASCII表上的相减

        Character character1=new Character('A');
        System.out.println(character.equals('A'));//true
        System.out.println(character.equals(character1));//true  说明不是在常量池中进行比较是否为统一对象
        System.out.println(character==character1);
        //!==号只会判断引用是否相等不会判断数值是否相等

        //判断字符是否为数字
        System.out.println(Character.isDigit(12));
        //判断是否为字符
        System.out.println(Character.isLetter(character));

    }
}
