<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加员工信息</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/index_work.css" />
</head>
<body>

<form action="emp" method="post">  <!--控制层的映射信息-->
    <table>
        <tr>
            <th colspan="2">添加员工信息</th>
        </tr>
        <tr>
            <td>LASTNAME</td>
            <td>
                <input type="text" name="lastName" />
            </td>
        </tr>
        <tr>
            <td>EMAIL</td>
            <td>
                <input type="text" name="email" />
            </td>
        </tr>
        <tr>
            <td>GENDER</td>
            <td>
                <input type="radio" name="gender" value="1" />男
                <input type="radio" name="gender" value="0" />女
            </td>
        </tr>
        <tr>
            <td>DEPARTMENT</td>
            <td>
                <select name="department.id">
                    <option>-SELECT DEPARTMENT-</option>
                    <c:forEach items="${depts }" var="dept"> <!--遍历控制层返回给客户端的部门信息-->
                        <option value="${dept.id }">${dept.departmentName }</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="ADD" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>