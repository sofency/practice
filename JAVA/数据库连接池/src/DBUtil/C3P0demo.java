package DBUtil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: DBUtil
 * @Version: 1.0
 */
public class C3P0demo {
    public static DataSource getDataSourceByC3P0() throws Exception {
        ComboPooledDataSource  c3p0 = new ComboPooledDataSource();
        c3p0.setDriverClass("oracle.jdbc.driver.OracleDriver");
        c3p0.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
        c3p0.setUser("sofency");
        c3p0.setPassword("19980120");
        c3p0.setInitialPoolSize(20);
        return c3p0;
    }
    public static DataSource getDataSourceWithC3P0ByXml(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("sofency");
        return c3p0;
    }

}
