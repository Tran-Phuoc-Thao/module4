<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 09/06/2023
  Time: 7:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="tuDien" method="post">
<table>
    <tr>
        <th style="color: chocolate;font-weight:bold">
            ENGLISH
        </th>
        <th>
            VIETNAME
        </th>
    </tr>
    <tr>
        <td>
            <input type="text" name="tiengAnh">
        </td>
        <td>
            ${tiengViet}
        </td>
    </tr>
    <tr>
        <td><button>Search</button></td>
    </tr>
    <tr>
        <c:if test="${message != null}">
        <td>
            <a style="color: red" >Không Tìm Thấy</a>
        </td>
        </c:if>
    </tr>
</table>
</form>
</body>
</html>
