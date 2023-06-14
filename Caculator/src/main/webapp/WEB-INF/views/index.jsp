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
<h1>CaCuLaTor</h1>
<form action="/CaCuLaTor/result" method="post">
    <input type="text" name="operand1" placeholder="First Operand">
    <input type="text" name="operand2" placeholder="Second Operand"><br/>
    <br/>
    <button name="operator" value="+">Addiction(+)</button>
    <button name="operator" value="-">Subtraction(-)</button>
    <button name="operator" value="*">Multiplication(x)</button>
    <button name="operator" value="/">Division(/)</button>
    <hr/>
</form>
<a>${result}</a>
<a>${message}</a>
</body>
</html>
