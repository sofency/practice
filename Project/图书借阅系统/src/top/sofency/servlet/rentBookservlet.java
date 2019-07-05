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
import java.text.ParseException;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
@WebServlet(name = "rentBookservlet")
public class rentBookservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId=request.getParameter("bookId");//获取书名
        String account=request.getParameter("account");//获取用户账户

        loginFunction func=new loginFunction();
        int result=0;
        try {
            result=func.rent(bookId,account);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out=response.getWriter();
        switch (result){
            case 0: out.print("0");break;
            case 1: out.print("1");break;
            case 2: out.print("2");break;
            case 3: out.print("3");break;
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
