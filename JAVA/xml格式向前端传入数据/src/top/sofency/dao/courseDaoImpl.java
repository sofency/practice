package top.sofency.dao;

import top.sofency.entity.Course;
import top.sofency.entity.TrainItem;

import java.sql.*;
import java.util.ArrayList;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.dao
 * @Version: 1.0
 */
public class courseDaoImpl implements courseDao{

    @Override
    public ArrayList<Course> selectByItemId(int id) {
        ArrayList<Course> list=new ArrayList<Course>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //添加驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接
            conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            //写sql语句
            String sql="select * from course1 where itemId=?";
            //虚拟执行sql语句
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            //得出结果
            rs=ps.executeQuery();
            //得出结果
            while(rs.next()){
                Course course=new Course();
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setPeriod(rs.getInt(3));
                course.setItemId(rs.getInt(4));
                course.setDetails(rs.getString(5));
                list.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        closeConn(conn, ps, rs);
        System.out.println(list);
        return list;
    }

    private void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course selectByCourseId(int id) {
        Course course=new Course();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //添加驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接
            conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            //写sql语句
            String sql="select * from course1 where COURSEID=?";
            //虚拟执行sql语句
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            //得出结果
            rs=ps.executeQuery();
            //得出结果
            while(rs.next()){
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setPeriod(rs.getInt(3));
                course.setItemId(rs.getInt(4));
                course.setDetails(rs.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        closeConn(conn, ps, rs);
        return course;
    }
}
