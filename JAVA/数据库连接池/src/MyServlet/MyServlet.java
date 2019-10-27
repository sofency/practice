package MyServlet;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
@WebServlet(name = "/DataSourceFactory")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource dbcp =null;
        Properties props =new Properties();
        InputStream input= this.getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");

        //props.load(new FileReader("/WEB_INF/classes/dbcpconfig.properties"));//将数据输入流传进来进行解析
        System.out.println(props);
        try {
            dbcp = BasicDataSourceFactory.createDataSource(props);//
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dbcp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
