package top.sofency.servlet;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import top.sofency.dao.courseDaoImpl;
import top.sofency.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
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
public class courseServletXML extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag=request.getParameter("flag");
        courseDaoImpl func=new courseDaoImpl();
//        if("train".equals(flag)){//跟据培训项目查找对应的课程信息
//            int itemId=Integer.parseInt(request.getParameter("itemId"));
//            ArrayList<Course> list=func.selectByItemId(itemId);
//            for (Course course:list){
//                str+=course.getCourseId()+","+course.getCourseName()+";";
//            }
//            if(str.endsWith(";")){
//                str=str.substring(0,str.length()-1);
//            }
//            System.out.println(str);
//        }else{//根据课程编号查询详细信息
//            int courseId=Integer.parseInt(request.getParameter("courseId"));
//            Course course=func.selectByCourseId(courseId);
//            if(course!=null){
//                str=course.getCourseId()+","+course.getCourseName()+","+course.getPeriod()+","+course.getDetails();
//                System.out.println(str);
//            }
//        }

        Document document=null;
        ByteArrayOutputStream baos=null;
        if("train".equals(flag)){
            //跟据培训项目查找对应的课程信息
            int itemId=Integer.parseInt(request.getParameter("itemId"));
            ArrayList<Course> list=func.selectByItemId(itemId);

            document = DocumentHelper.createDocument();
            Element root=document.addElement("courses");
            //写成XML文件
            for(Course course:list){
                Element cour=root.addElement("course");
                cour.addElement("courseId").setText(course.getCourseId()+"");
                cour.addElement("courseName").setText(course.getCourseName());
            }

            baos=new ByteArrayOutputStream();
            //设置格式
            OutputFormat format=new OutputFormat("  ",true,"utf-8");
            XMLWriter xm=new XMLWriter(baos,format);
            xm.write(document);
        }else{
            document=DocumentHelper.createDocument();
            Element root=document.addElement("course1");
            int courseId=Integer.parseInt(request.getParameter("courseId"));
            Course course=func.selectByCourseId(courseId);
            if(course!=null){
                root.addElement("courseName").setText(course.getCourseName());
                root.addElement("coursePeriod").setText(course.getPeriod()+"");
                root.addElement("courseDetail").setText(course.getDetails());
            }
            baos=new ByteArrayOutputStream();
            //设置格式
            OutputFormat format=new OutputFormat("  ",true,"utf-8");
            XMLWriter xm=new XMLWriter(baos,format);
            xm.write(document);
      }

        response.setContentType("text/html;charset=utf8");
        PrintWriter out =response.getWriter();
        out.print(baos);
        out.flush();
        out.close();
    }
}
