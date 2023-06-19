<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 09/06/2023
  Time: 8:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="settingsMail" method="post">
<h1>Settings</h1>
<table>
    <tr>
        <td style="font-weight: bold">
            Languages
        </td>
        <td>
            <form:select path="language">
            <form:options  items="${languagesList}"/>
            </form:select>
        </td>

    </tr>
    <tr>
        <td style="font-weight: bold">
            Page Size
        </td>
        <td>
            <form:select path="pageSize">
            <form:options  items="${pageSizeList}"/>
            </form:select>
        </td>
    </tr>
    <tr>
        <td style="font-weight: bold">
            Spam filter
        </td>
        <td>
            <form:checkbox path="spamFilter"/>
        </td>
    </tr>
    <tr>
        <td style="font-weight: bold">
            Signature
        </td>
        <td>
            <form:textarea path="signature"/>
        </td>
    </tr>

</table>

<form:button>Save</form:button>
</form:form>
<a style="color: red">${mess}</a><br>
<a>${mail}</a>
</body>
</html>
