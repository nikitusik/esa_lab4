<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 1/8/2021
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Faculty</title>
</head>
<body>
<h3>Faculties list</h3>
<c:if test="${!empty faculties}">
    <table>
        <thead>
        <tr>
            <td>Id</td>
            <td>Name</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${faculties}" var="faculty">
            <tr>
                <td>${faculty.id}</td>
                <td>${faculty.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
