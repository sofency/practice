<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %><%--
  Created by IntelliJ IDEA.
  User: sofency
  Date: 2019/9/9
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
hello world
  <%
    //Context ctx = new InitialContext();
    //String name = (String)ctx.lookup("java:comp/env/jndiName");获取 context.xml中的数据
    //out.print(name);
    String flag = (String)request.getAttribute("flag");
    out.print(flag);
  %>
<a href="MyServlet">MyServlet</a>
  </body>
</html>
