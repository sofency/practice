package top.sofency.servlet;

import top.sofency.dao.TrainItemDaoImpl;
import top.sofency.entity.TrainItem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
public class trainItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TrainItemDaoImpl trainItemDao=new TrainItemDaoImpl();
        ArrayList<TrainItem> list=trainItemDao.selectAll();

        String str="";
        for (TrainItem trainItem:list) {
            str+=trainItem.getItemId()+","+trainItem.getItemName()+";";
        }
        if(str.endsWith(";")){
            str=str.substring(0,str.length()-1);
        }
        response.setContentType("text/html;charset=utf8");
        PrintWriter out =response.getWriter();
        out.print(str);
        out.flush();
        out.close();
    }
}
