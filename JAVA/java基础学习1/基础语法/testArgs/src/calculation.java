/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 从命令行接受参数
 * @Version: 1.0
 */
public class calculation {
    public static void main(String[] args) {
        if(args.length!=3){
            System.out.println("wrong input");
            System.exit(0);
        }
        
        //将字符转化为数字语法 Integer.parseInt(字符)
        int result=0;
        switch (args[1].charAt(0)){
            case '+':result=Integer.parseInt(args[0])+Integer.parseInt(args[2]);break;
            case '-':result=Integer.parseInt(args[0])-Integer.parseInt(args[2]);break;
            case '*':result=Integer.parseInt(args[0])*Integer.parseInt(args[2]);break;
            case '/':result=Integer.parseInt(args[0])/Integer.parseInt(args[2]);break;
        }
        System.out.println(args[0]+" "+args[1]+" "+args[2]+" = "+result);
    }
}
