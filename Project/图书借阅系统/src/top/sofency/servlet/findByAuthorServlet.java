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
import java.util.ArrayList;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
@WebServlet(name = "findByAuthorServlet")
public class findByAuthorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author=request.getParameter("author");//获取作者的姓名
        loginFunction func=new loginFunction();//创建对象
        ArrayList<book> list=null;//创建列表
        try {
            list = func.searchByAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        response.setContentType("text/plain;charset=utf-8");//设置响应数据的类型
        PrintWriter out=response.getWriter();//开始动笔写入
        String string="";
        if(list!=null) {
            for (book b : list) {
                string += b.getBookId() + "," + b.getBookName() + "," + b.getAddress() + "," + b.getBookNumber() + "," + b.getRemainNumber() + "," + b.getClarifyString() + "," + b.getAuthor() + ";";
            }

            string = string.substring(0, string.length() - 1);//删去最后一个分号不然影响分组
        }
        out.print(string);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
