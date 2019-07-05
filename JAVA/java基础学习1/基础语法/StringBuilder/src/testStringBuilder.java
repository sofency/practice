/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class testStringBuilder {
    public static void main(String[] args) {

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            char temp=(char)('a'+i);
            sb.append(temp);
        }

        System.out.println(sb);

        //转置字符串
        sb.reverse();
        System.out.println(sb);

        //链式插入字符
        sb.insert(0,"sofency").insert(3,"like").insert(5,"wuting");
        System.out.println(sb);
        //链式删除类似


    }
}
