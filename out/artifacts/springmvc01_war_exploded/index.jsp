<%--
  Created by IntelliJ IDEA.
  User: MECHREV
  Date: 2021/1/4
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
  <head>
    <title>请求首页</title>
  </head>
  <body>
  <!-- 初始学习 TestController-->
  <a href="hello"> 请求首页 </a> <!-- 请求方式为get 请求参数为hello -->
  <br/>
  <!-- REST风格的增删改查 RESTController-->
  <a href="testRESTGet/1001"> testREST GET </a> <!-- 查 请求方式为get 请求参数为testRESTGet/1001 -->
  <br/>
  <form action="testRESTPost" method="POST">     <!--增 请求方式为post 请求参数为testRESTPost -->
    <input type="submit" value="测试POST">
  </form>
  <br/>
  <form action="testRESTPost" method="POST">     <!--改 请求方式为post 请求参数为testRESTPost -->
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="测试PUT">
  </form>
  <br/>
  <form action="testRESTDelete/1001" method="POST">     <!--删 请求方式为post 请求参数为testRESTPost -->
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="测试Delete">
  </form>
  <br/>

  <!-- 获取请求参数 && 往作用域中放值-->
  <form action="param" method="post">
    username:<input type="text" name="username" /><br />
    password:<input type="text" name="password" /><br />
    age:<input type="text" name="age" /><br />
    province:<input type="text" name="province" /><br />
    city:<input type="text" name="city" /><br />
    country:<input type="text" name="country" /><br />
    <input type="submit" value="添加" />
  </form>
  <br/>
  <!-- 获取请求参数通过级联User的address -->
  <form action="param2" method="post">
    id:<input type="text" name="id" /><br />
    username:<input type="text" name="username" /><br />
    password:<input type="text" name="password" /><br />
    age:<input type="text" name="age" /><br />
    province:<input type="text" name="address.province" /><br />
    city:<input type="text" name="address.city" /><br />
    country:<input type="text" name="address.country" /><br />
    <input type="submit" value="添加POJO" />
  </form>
  <br/>


  </body>
</html>
