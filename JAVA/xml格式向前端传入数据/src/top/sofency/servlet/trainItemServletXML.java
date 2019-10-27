package top.sofency.servlet;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;  //导入META-INF文件夹
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import top.sofency.dao.TrainItemDaoImpl;
import top.sofency.entity.TrainItem;

import javax.servlet.ServletException;
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
public class trainItemServletXML extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        TrainItemDaoImpl trainItemDao=new TrainItemDaoImpl();
        ArrayList<TrainItem> list=trainItemDao.selectAll();

        //使用dom4j
        Document document =DocumentHelper.createDocument();
        Element root=document.addElement("TrainItems");

        //
        for(TrainItem item:list){
            Element trainItem=root.addElement("TrainItem");//向根节点里面添加子元素
            trainItem.addElement("itemId").setText(item.getItemId()+"");
            trainItem.addElement("itemName").setText(item.getItemName());
        }

        ByteArrayOutputStream baos=new ByteArrayOutputStream();//字节数据输出流
        OutputFormat format=new OutputFormat("  ",true,"utf-8");
        XMLWriter xm=new XMLWriter(baos,format);
        xm.write(document); //写到输出流中 将document 文件通过format格式通过输出流baos传送到外面
        System.out.println(baos);

        response.setContentType("text/xml;charset=utf8");//指定响应类型为xml
        PrintWriter out =response.getWriter();
        out.print(baos);
        out.flush();
        out.close();
    }
}
