package top.sofency.servlet;

import top.sofency.dao.courseDaoImpl;
import top.sofency.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: ${PACKAGE_NAME}
 * @Version: 1.0
 */
@WebServlet(name = "courseServlet")
public class courseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag=request.getParameter("flag");
        String str="";
        courseDaoImpl func=new courseDaoImpl();
        if("train".equals(flag)){//跟据培训项目查找对应的课程信息
            int itemId=Integer.parseInt(request.getParameter("itemId"));
            ArrayList<Course> list=func.selectByItemId(itemId);
            for (Course course:list){
                str+=course.getCourseId()+","+course.getCourseName()+";";
            }
            if(str.endsWith(";")){
                str=str.substring(0,str.length()-1);
            }
            System.out.println(str);
        }else{//根据课程编号查询详细信息
            int courseId=Integer.parseInt(request.getParameter("courseId"));
            Course course=func.selectByCourseId(courseId);
            if(course!=null){
                str=course.getCourseId()+","+course.getCourseName()+","+course.getPeriod()+","+course.getDetails();
                System.out.println(str);
            }
        }
        response.setContentType("text/html;charset=utf8");
        PrintWriter out =response.getWriter();
        out.print(str);
        out.flush();
        out.close();
    }
}
