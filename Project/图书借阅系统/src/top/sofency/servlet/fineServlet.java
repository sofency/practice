package top.sofency.servlet;

import top.sofency.function.loginFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
@WebServlet(name = "fineServlet")
public class fineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId=request.getParameter("bookId");//书的编号
        String account=request.getParameter("account");//账号
        loginFunction func=new loginFunction();//获取对象
        float money=0;
        PrintWriter out=null;
        try {
            money=func.returnBook(bookId,account);
            response.setContentType("text/plain;charset=utf-8");
            out=response.getWriter();
            if(money>0){
                out.print(money);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
