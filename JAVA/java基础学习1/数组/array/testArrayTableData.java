import java.util.Arrays;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class testArrayTableData {
    public static void main(String[] args) {
        Object[] emp1={"41702070701","sofency",18,"programer","1998-01-20"};
        Object[] emp2={"41702070702","Alice",19,"Teacher","1986-02-20"};
        Object[] emp3={"41702070703","WuTing",20,"girlGod","1998-01-01"};
        Object[][] tableData=new Object[3][];
        tableData[0]= emp1;
        tableData[1]= emp2;
        tableData[2]= emp3;
        for (Object[] emp:tableData
             ) {
            System.out.println(Arrays.toString(emp));//Arrays.toString只能用来输出一位数组
        }

}
}

