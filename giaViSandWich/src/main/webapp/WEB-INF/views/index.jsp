<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 09/06/2023
  Time: 8:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SandWich Condiments</h1>
<form action="sandwich/choose" method="post">
<table>
    <tr>
        <td>
            <input type="checkbox" name="condiment" value="Lettuce">Lettuce
            <input type="checkbox" name="condiment" value="Tomato">Tomato
            <input type="checkbox" name="condiment" value="Mustard">Mustard
            <input type="checkbox" name="condiment" value="Sprouts">Sprouts
        </td>
    </tr>
    <tr>
        <hr>
    </tr>
    <tr><button>save</button></tr>
    <tr>
        <c:if test="${giaVi != null or message != null}">
            <a style="color: chocolate">Gia vị đã chọn là : ${giaVi} </a>
        </c:if>
    </tr>
</table>
</form>

</body>
</html>
