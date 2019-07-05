/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试StringBuilder and StringBuffer
 * @Version: 1.0
 */
public class stringBuilder {
    //String和StringBuilder的区别就是后者可以追加字符，而前者对象建立后就确定了唯一的值无法改动
    public static void main(String[] args) {
        String str=new String("sofency");
        //突然心血来潮想要在名字后面追加字符串 is cool咋办，用concat的话(str本身依旧未变)
        //System.out.println(str.append());错误的写法

        StringBuilder str1=new StringBuilder("sofency");
        //我想加上is cool
        str1.append(" is cool");
        System.out.println(str1);//完美的显示了 sofency is cool .hahaha
        //加上我的好朋友的名字alice
        str1.insert(7," and alice");//把下标为7的字符替换为后面的字符串
        System.out.println(str1);
        //突然发现该句子不符合语法规则 修改谓语动词

        str1.replace(18,20,"are");
        System.out.println(str1);
        //完美
        //Alice不和我玩了，决定把他的名字删了 他不酷
        str1.delete(7,17);//(7-16)
        str1.replace(8,11,"is");
        System.out.println(str1);
        //哼哼

        //返回str1的容量
        System.out.println(str1.capacity());
        str1.trimToSize();
        System.out.println(str1.capacity());//现在容量的大小就是字符的个数
        //可能是垃圾的回收吧
    }

}
