<%-- 
    Document   : accountinfo
    Created on : 2017-07-08, 09:37:48
    Author     : miszcz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account informations</title>
    <form action="./AccountServlet" method="POST">
        <table>
            <tr>
                <td>AccountID</td>
                <td><input type="text" name="accountId" value="${account.accountId}" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${account.name}" /></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><input type="text" name="accountId" value="${account.surname}" /></td>
            </tr>
            <tr>
                <td colspan="2"></td>
            <input type="submit" name="action" value="Add" />
            <input type="submit" name="action" value="Edit" />
            <input type="submit" name="action" value="Delete" />
            <input type="submit" name="action" value="Search" />
            </tr>
        </table>
    </form>
</head>
<body>
    <h1>Account informations</h1>

    <br>
    <table border ="1">
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
            <c:forEach items="${allAccounts}" var="acc">
            <tr>
                <td>${acc.accountId}</td>
                <td>${acc.name}</td>
                <td>${acc.surname}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
