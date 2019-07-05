package top.sofency.function;

import top.sofency.entify.book;
import top.sofency.entify.loginStu;
import top.sofency.entify.rentPerson;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.top.sofency.loginFunction
 * @Version: 1.0
 */
public class loginFunction {

    public loginStu login(String account) throws SQLException {
        //连接数据库
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        loginStu u=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            conn.setAutoCommit(false);
            String sql="select * from loginSt where Accou=?";
            ps=conn.prepareStatement(sql);//虚拟执行sql语句
            //补位
            ps.setString(1,account);
            //获取执行结果
            rs=ps.executeQuery();//执行查询
            System.out.println("检查插入数据库账户");
            while(rs.next()){
                u=new loginStu();
                u.setAccount(rs.getString(1));
                u.setPwd(rs.getString(2));
                u.setIdentify(rs.getString(3));
            }
            System.out.println(u);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.commit();
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    //查找借阅的书籍
    public ArrayList<rentPerson> rented(String identify) throws SQLException {
        ArrayList<rentPerson> list=new ArrayList<rentPerson>();

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rSet=null;

        //创建连接对象
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            conn.setAutoCommit(false);
            String sql="select to_char(rentDate,'yyyy-mm-dd'),bookId,Identifyid,to_char(returnDate,'yyyy-mm-dd') from RentPerson where Identifyid = ?";
            //虚拟执行sql语句
            ps=conn.prepareStatement(sql);
            ps.setString(1,identify );
            //执行查询
            rSet=ps.executeQuery();
            while(rSet.next()) {
                rentPerson b=new rentPerson();
                b.setRentDate(rSet.getDate(1));
                b.setBookId(rSet.getString(2));
                b.setIdentify(rSet.getString(3));
                b.setReturnDate(rSet.getDate(4));
                list.add(b);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.commit();
        rSet.close();
        ps.close();
        conn.close();
        return list;
    }
    //根据图书编号查询书籍
    public book searchByBookId(String bookId) throws SQLException {

        Connection connection=null;
        PreparedStatement pStatement=null;
        ResultSet rSet=null;
        book b=new book();

        //创建连接
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            //写sql语句
            String sqlString="select bookId,bookName,author from book where bookId=?";
            //虚拟执行sql语句
            pStatement=connection.prepareStatement(sqlString);
            pStatement.setString(1, bookId);

            //执行
            rSet=pStatement.executeQuery();//执行查询
            while(rSet.next()) {
                b.setBookId(rSet.getString(1));
                b.setBookName(rSet.getString(2));
                b.setAuthor(rSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection.commit();
        rSet.close();
        pStatement.close();
        connection.close();
        return b;
    }

    //根据书名查找书籍
    public book searchByName(String Name) throws SQLException {

        Connection connection=null;
        PreparedStatement pStatement=null;
        ResultSet rSet=null;
        book b=null;
        //创建连接对象
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            //写sql语句
            String sql="select * from book where bookName =?";

            //虚拟执行sql语句
            pStatement=connection.prepareStatement(sql);
            //设置参数
            pStatement.setString(1, Name);
            rSet=pStatement.executeQuery();//执行查询

            while(rSet.next()) {
                b=new book();
                b.setBookId(rSet.getString(1));
                b.setBookName(rSet.getString(2));
                b.setAddress(rSet.getString(3));
                b.setBookNumber(rSet.getInt(4));
                b.setRemainNumber(rSet.getInt(5));
                b.setClarifyString(rSet.getString(6));
                b.setAuthor(rSet.getString(7));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection.commit();//提交事务
        rSet.close();
        pStatement.close();
        connection.close();
        return b;
    }

    //根据作者查找书籍
    public ArrayList<book> searchByAuthor(String Author) throws SQLException {
        // TODO Auto-generated method stub
        Connection connection=null;
        PreparedStatement pStatement=null;
        ResultSet rSet=null;

        ArrayList<book> list=new ArrayList<book>();
        //创建连接对象
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            //写sql语句
            String sql="select * from book where author =?";

            //虚拟执行sql语句
            pStatement=connection.prepareStatement(sql);
            //设置参数
            pStatement.setString(1, Author);
            rSet=pStatement.executeQuery();//执行查询

            test(rSet, list);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection.commit();
        rSet.close();
        pStatement.close();
        connection.close();
        if(list.size()==0) return null;
        else{
            return list;
        }

    }

    //根据类型查找书籍
    public ArrayList<book> searchByType(String Type) throws SQLException {
        // TODO Auto-generated method stub
        Connection connection=null;
        PreparedStatement pStatement=null;
        ResultSet rSet=null;

        ArrayList<book> list=new ArrayList<book>();
        //创建连接对象
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            //写sql语句
            String sql="select * from book where Clarify =?";

            //虚拟执行sql语句
            pStatement=connection.prepareStatement(sql);
            //设置参数
            pStatement.setString(1, Type);
            rSet=pStatement.executeQuery();//执行查询

            test(rSet, list);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection.commit();
        rSet.close();
        pStatement.close();
        connection.close();
        if(list.size()==0) return null;
        else{
            return list;
        }
    }

    public void test(ResultSet rSet, ArrayList<book> list) throws SQLException {
        while(rSet.next()) {
            book b=new book();
            b.setBookId(rSet.getString(1));
            b.setBookName(rSet.getString(2));
            b.setAddress(rSet.getString(3));
            b.setBookNumber(rSet.getInt(4));
            b.setRemainNumber(rSet.getInt(5));
            b.setClarifyString(rSet.getString(6));
            b.setAuthor(rSet.getString(7));
            list.add(b);
        }
    }

    //根据账号查询最大借书量
    public int showMaxNum(String account) throws SQLException {

        Connection connection=null;
        PreparedStatement pStatement=null;
        ResultSet rSet=null;
        int number=0;
        //创建连接
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            //写sql语句
            String sqlString="select rentMaxNumber from Person where identifyid=?";
            pStatement=connection.prepareStatement(sqlString);
            pStatement.setString(1, account);
            //执行
            rSet=pStatement.executeQuery();//执行查询
            while(rSet.next()) {
                number=rSet.getInt(1);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //虚拟执行sql语句
        connection.commit();//提交事务
        rSet.close();
        pStatement.close();
        connection.close();
        return number;//返回该账号的最大借书数量
    }

    //借书的权限不足已借书的数量超过最大借书量
    public int rent(String bookId,String account) throws SQLException, ParseException {
        ArrayList<rentPerson> list=rented(account);
        //将编号的个数减一  修改数据库中该书的剩余数量
        if(showNumber(bookId)==0) {
           return 0;//图书馆无该藏书

        }else if(list.size()==showMaxNum(account)){//借书的数量==最大借书数量则提示权限不足
            return 1;//达到最大借书数量

        }else {
            int retu=this.updateRent(bookId,account);
            return retu;//借书结果
        }
    }
    //根据图书编号查询剩余书的数量
    public int showNumber(String bookid) throws SQLException {

        Connection connection=null;
        PreparedStatement pStatement=null;
        ResultSet rSet=null;
        int number=0;
        //创建连接
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            //写sql语句
            String sqlString="select remainNumber from book where bookId=?";
            //虚拟执行sql语句
            pStatement=connection.prepareStatement(sqlString);
            pStatement.setString(1, bookid);
            //执行
            rSet=pStatement.executeQuery();//执行查询
            while(rSet.next()) {
                number=rSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection.commit();
        rSet.close();
        pStatement.close();
        connection.close();
        return number;//返回书的数量
    }

    //更新借书操作
    public int updateRent(String bookId,String account) throws SQLException, ParseException {
        Connection connection = null;
        PreparedStatement pStatement = null;
        PreparedStatement pStatement2 = null;

        Calendar now = Calendar.getInstance();//获取实例对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar future = Calendar.getInstance();//获取Calendar的实例
        int year = now.get(Calendar.YEAR);
        int monthRent = now.get(Calendar.MONTH);
        int monthReturn = (now.get(Calendar.MONTH) + 2) % 12 + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        now.set(year, monthRent, day);//设置借书的日期
        future.set(year, monthReturn, day);//设置还书的日期

        String signTimetString = df.format(now.getTime());//将借书日期转化为字符串
        java.util.Date uDate = df.parse(signTimetString);//将还书日期转化为字符串

        String signString = df.format(future.getTime());//将借书日期转化到format 的格式
        java.util.Date uDatereturn = df.parse(signString);//将还书日期转化到format的格式


        Date dateRent = new Date(uDate.getTime());//将util格式的日期转化为sql日期
        Date dateReturn = new Date(uDatereturn.getTime());

        ArrayList<rentPerson> list = new ArrayList<rentPerson>();
        int rentedNumber = list.size() + 1;//借书的数量加一

        int a = 0;
        int b = 0;
        //创建连接
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency", "19980120");
            connection.setAutoCommit(false);
            String sqlString = "INSERT INTO RentPerson VALUES(?,?,?,?)";
            String sqlupdateString = "UPDATE book SET RemainNumber=RemainNumber-1 WHERE bookId=?";
            //虚拟执行sql语句
            pStatement = connection.prepareStatement(sqlString);
            pStatement2 = connection.prepareStatement(sqlupdateString);//执行更新book表中的剩余数量

            pStatement.setDate(1, dateRent);
            pStatement.setString(2, bookId);
            pStatement.setString(3, account);
            pStatement.setDate(4, dateReturn);
            //执行
            pStatement2.setString(1, bookId);
            a = pStatement.executeUpdate();//执行查询
            b = pStatement2.executeUpdate();//执行更新
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection.commit();

        connection.close();
        pStatement.close();
        pStatement2.close();
        if (a == 1 && b == 1) {
            return 2;
        } else {
           return 3;
        }
    }

    //还书功能
    public float returnBook(String bookId,String account) throws SQLException {
        float money=0;
        int sum=fine(bookId,account);//获取
        if(sum>0){
            money= (float) (sum*0.2);//超出一天需支付0.2元
        }
        //数据库更新book书的剩余量
        int remain=updateReturnBook(bookId);//图书存量加一
        int delete=deleteRentBook(bookId,account);//删除已经借阅的记录
        if(remain==1&&delete==1) {
            return money;//返回缴纳的罚金
        }else {
            return -1;//故障返回值
        }

        //删除rentPerson对应书的记录 首先取出应该归还的日期 与现在的日期进行比较 如果大于应该归还的日期 提示用户的罚款
    }

    //更新馆藏书记录
    public int updateReturnBook(String bookId) throws SQLException {
        Connection connection=null;
        PreparedStatement pStatement=null;
        int a=0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);
            String sqlString="update book set remainNumber=remainNumber+1 where bookId=?";
            pStatement=connection.prepareStatement(sqlString);//虚拟执行sql语句
            pStatement.setString(1, bookId);
            a=pStatement.executeUpdate();//执行更新返回结果
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (pStatement != null) {
                pStatement.close();
                connection.close();
            }
        }
        if(a==0) {
            return 0;//表示更新成功
        }else {
            return 1;//表示更新失败
        }
    }
    //删除借书人的借书记录
    public int  deleteRentBook(String bookId,String account) throws SQLException {
        Connection connection=null;
        PreparedStatement pStatement=null;
        int a=0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);

            String sqlString="delete from RentPerson where bookId=?";

            pStatement=connection.prepareStatement(sqlString);//执行语句
            pStatement.setString(1, bookId);
            a=pStatement.executeUpdate();//执行结果
            connection.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (pStatement != null) {
                pStatement.close();
                connection.close();
            }
        }

        if(a==0) {
            return 0;
        }else {
            return 1;
        }
    }

    //罚款操作
    public int fine(String bookId,String account) throws SQLException {
        int sum=0;//罚款金额
        Connection connection=null;
        PreparedStatement pStatement=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "sofency","19980120");
            connection.setAutoCommit(false);

            String sqlString="select rounnd(sysdate-RETURNDATE) from RentPerson where bookId=? and IDENTIFY=?";

            pStatement=connection.prepareStatement(sqlString);//执行语句
            pStatement.setString(1, bookId);
            pStatement.setString(2,account);
            sum=pStatement.executeUpdate();//执行结果
            connection.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pStatement != null) {
                pStatement.close();
                connection.close();
            }
        }
        return sum;//返回是否超时间
    }

}
