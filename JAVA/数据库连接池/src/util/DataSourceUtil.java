package util;

import DBUtil.DBCPdemo;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: DBUtil
 * @Version: 1.0
 */
public class DataSourceUtil {
    public static DataSource getDataSourceWithDBCP(){
        BasicDataSource dbcp =new BasicDataSource();
        dbcp.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        dbcp.setUsername("sofency");
        dbcp.setPassword("19980120");
        dbcp.setInitialSize(20);//连接池的最多链数
        dbcp.setMaxActive(10);
        return dbcp;
    }

    public static DataSource getDataSourceWithDBCPByProperties(){
        DataSource dbcp =null;
        Properties props =new Properties();
        InputStream input= new DBCPdemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        try {
            props.load(input);//将数据输入流传进来进行解析
            dbcp = BasicDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dbcp;
    }

    public static DataSource getDataSourceByC3P0() {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("oracle.jdbc.driver.OracleDriver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        c3p0.setUser("sofency");
        c3p0.setPassword("19980120");
        c3p0.setInitialPoolSize(20);
        return c3p0;
    }
    public static DataSource getDataSourceWithC3P0ByXml(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("sofency");
        System.out.println(c3p0);
        return c3p0;
    }
}
