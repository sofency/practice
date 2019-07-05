package top.sofency.servlet;


import top.sofency.entify.loginStu;
import top.sofency.function.loginFunction;

import javax.servlet.ServletException;
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
public class indexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(1);
        String account=request.getParameter("account");
        String pwd=request.getParameter("password");
        String identify=request.getParameter("identify");
        loginFunction func=new loginFunction();//导入类  之前改过名字后但是生成的class文件名字没改所以导致无法再次导入此类
        loginStu u= null;
        String password="";
        try {
            u = func.login(account);
            if(u==null){
                password="0";
            }else {
                password = u.getPwd();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(u);
        response.setContentType("text/plain;charset=utf-8");

        PrintWriter out=response.getWriter();//拿出笔
        if(password.equals(pwd)){
            out.print("ok");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
