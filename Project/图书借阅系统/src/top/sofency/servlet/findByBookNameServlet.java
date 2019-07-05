package top.sofency.servlet;

import top.sofency.entify.book;
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
@WebServlet(name = "findByBookNameServlet")
public class findByBookNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName=request.getParameter("bookName");//获取到书名
        loginFunction func=new loginFunction();//获取对象
        book b =null;
        try {
            b =func.searchByName(bookName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out=response.getWriter();//拿出笔
        String str="";
        if(b!=null) {
            str = b.getBookId() + "," + b.getBookName() + "," + b.getAddress() + "," + b.getBookNumber() + "," + b.getRemainNumber() + "," + b.getClarifyString() + "," + b.getAuthor();
        }
        out.print(str);//要么为空 要么为值
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
