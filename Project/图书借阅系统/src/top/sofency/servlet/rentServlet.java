package top.sofency.servlet;

import top.sofency.entify.book;
import top.sofency.entify.rentPerson;
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
@WebServlet(name = "rentServlet")
public class rentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");//获取账户信息
        loginFunction func=new loginFunction();//导入功能类
        ArrayList<rentPerson> list= null;//获取列表信息
        String str="";
        try {
            list = func.rented(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            for (rentPerson rentperson:list) {
                book b=new book();//获取书的对象
                b=func.searchByBookId(rentperson.getBookId());
                str+=rentperson.getBookId()+","+b.getBookName()+","+b.getAuthor()+","+rentperson.getRentDate()+","+rentperson.getReturnDate()+";";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(str.endsWith(";")){
            str=str.substring(0,str.length()-1);
        }
        response.setContentType("text/plain;charset=utf-8");//也可以指定为text/html
        PrintWriter out=response.getWriter();
        out.print(str);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
