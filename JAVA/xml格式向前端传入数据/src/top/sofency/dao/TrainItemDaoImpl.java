package top.sofency.dao;

import top.sofency.entity.TrainItem;

import java.sql.*;
import java.util.*;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.dao
 * @Version: 1.0
 */
public class TrainItemDaoImpl implements TrainItemDao {

    @Override
    public ArrayList<TrainItem> selectAll() {
        ArrayList<TrainItem> list=new ArrayList<TrainItem>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //添加驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            //写sql语句
            String sql="select * from TrainItem";
            //虚拟执行sql语句
            ps=conn.prepareStatement(sql);
            //得出结果
            rs=ps.executeQuery();
            //得出结果
            while(rs.next()){
                TrainItem trainItem=new TrainItem();
                trainItem.setItemId(rs.getInt(1));
                trainItem.setItemName(rs.getString(2));
                list.add(trainItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
