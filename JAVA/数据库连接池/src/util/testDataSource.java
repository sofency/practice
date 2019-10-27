package util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: util
 * @Version: 1.0
 */
public class testDataSource {


    //只会将结果的第一个值给返回
    public static void testArrayHandler(){
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceByC3P0());//使用  有参自动提交
        //ArrayHandler()只会返回第一条数据并且返回数组来存储结果
        Object[] student = null;
        try {
            student = runner.query("select * from student where sage>?",new ArrayHandler(),12);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Iterator<Object> list = obj.iterator();
        System.out.println(student[0]+"--"+student[1]+"--"+student[2]);
    }

    public static void testArrayListHandler(){
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceByC3P0());//使用  有参自动提交
        List<Object[]>  list=null;
        try {
            list = runner.query("select * from student where sage>?",new ArrayListHandler(),12);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(list!=null){
            Iterator<Object[]> li= list.iterator();//遍历容器  迭代器  不用知道里面的属性是什么以及里面属性的类型
            while(li.hasNext()){
                Object[] student = li.next();
                System.out.println(student[0]+"--"+student[1]+"--"+student[2]);
            }
        }
    }

    public static void testBean() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        studentBean stu = runner.query("select * from student where sage>?",new BeanHandler<studentBean>(studentBean.class),12);
        System.out.println(stu.getSname()+","+stu.getSage());
    }

    public static void testBeanList() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        List<studentBean> students = runner.query("select * from student where sage>?",new BeanListHandler<studentBean>(studentBean.class),12);
        for(studentBean student:students){
            System.out.println(student.getSname()+"--"+student.getSage());
        }
    }
    //BeanMapHandler
    public static void testBeanMapHandler() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        Map<BigDecimal,studentBean> students = runner.query("select * from student where sage>?",new BeanMapHandler<BigDecimal,studentBean>(studentBean.class,"sage"),12);
        //System.out.println(students);
        studentBean stu = students.get(new BigDecimal(21));
       // System.out.println(stu);
        System.out.println(stu.getSname()+"---"+stu.getSage());
    }

    public static void testMapHandler() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        Map<String,Object> student = runner.query("select * from student where sage>?",new MapHandler(),12);
        //System.out.println(students);
        System.out.println(student);
        // System.out.println(stu);

    }

    public static void testMapListHandler() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        List<Map<String,Object>> student = runner.query("select * from student where sage>?",new MapListHandler(),12);
        //System.out.println(students);
        System.out.println(student);
        // System.out.println(stu);

    }

    public static void testKeyedHandler() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        Map<String,Map<String,Object>> student = runner.query("select * from student where sage>?",new KeyedHandler<String>("sname"),12);
        //System.out.println(students);
        System.out.println(student);
        // System.out.println(stu);

    }

    //把年龄大于12的数据中再将其中的名字存储到List中
    public static void testColumnListHandler() throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());//获取连接源之后在进行查找操作
        List<String> student = runner.query("select * from student where sage>?",new ColumnListHandler<String>("sname"),12);
        //System.out.println(students);
        System.out.println(student);
        // System.out.println(stu);

    }


    //单值结果集
    public static void testScalarHandler() throws SQLException {
        QueryRunner  runner=new QueryRunner(DataSourceUtil.getDataSourceWithDBCP());
        //查询数值结果
//        BigDecimal result =runner.query("select count(*) from student where sage>?",new ScalarHandler<BigDecimal>(),12);
//        System.out.println(result);
        String password  =runner.query("select imgpath from dormitory where uaccount=?",new ScalarHandler<String>(),"41702070702");
        System.out.println(password);
    }
    public static void main(String[] args) throws SQLException {

        //测试tomcat的util方法
        //testArrayListHandler();
        testBeanList();
    }
}
