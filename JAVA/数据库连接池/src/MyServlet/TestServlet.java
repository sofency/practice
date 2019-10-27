package MyServlet;

import DBUtil.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
@WebServlet(name = "/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("sofency");
        String sql ="delete from student where sno=?";
        Object[] obj={18};
        int count = DBUtil.executeUpdate(sql,obj);
        System.out.println(count);
        //PrintWriter out=response.getWriter();
        if(count>0){
            //out.print("ok");
            request.setAttribute("flag","true");
        }else{
            //out.print("false");
            request.setAttribute("flag","flase");
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        out.flush();
//        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sofency");
        doPost(request,response);
    }
}
