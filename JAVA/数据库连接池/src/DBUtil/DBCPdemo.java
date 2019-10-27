package DBUtil;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: DBUtil
 * @Version: 1.0
 */
public class DBCPdemo {

    //tomcat-dbcp格式连接
    public static DataSource getDataSourceWithDBCP(){
        BasicDataSource dbcp =new BasicDataSource();//
        dbcp.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        dbcp.setUsername("sofency");
        dbcp.setPassword("19980120");
        dbcp.setInitialSize(20);//连接池的最多链数
        dbcp.setMaxActive(10);
        return dbcp;
    }


    //dbcp连接
    public static void getDataSourceWithDBCPByProperties() throws Exception {
        //加载配置文件
        DataSource dbcp =null;
        Properties  props =new Properties();
        InputStream input= new DBCPdemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        props.load(input);//将数据输入流传进来进行解析
        System.out.println(props);
        dbcp = BasicDataSourceFactory.createDataSource(props);//
        System.out.println(dbcp.getConnection());
    }


    //c3p0格式
    //连接池  ComboPooledDataSource
    //两种方式
    //硬编码  通过set方法进行设置数据
    //配置文件  通过properties进行配置文件
    //合二为一  通过DataPooledDataSource的构造方法参数区分  如果无参 硬编码  有参  配置文件





    public static void main(String[] args) throws Exception {
        //notClassFounddefError  表示缺少jar包
        //DataSource dbcp = getDataSourceWithDBCP();//获取dbcp
        getDataSourceWithDBCPByProperties();
    }
}
