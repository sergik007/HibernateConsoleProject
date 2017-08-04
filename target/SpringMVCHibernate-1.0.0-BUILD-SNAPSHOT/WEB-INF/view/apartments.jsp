<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Apartments</title>
</head>
<body>
<a href="/index.jsp">Start page</a>
<br/><br/>
<table>
<c:forEach var="apartment" items="${apartmentList}">
    <tr>
        <td><a href="apartment/${apartment.id}">${apartment.id}</a></td>
        <td>${apartment.name}</td>
    </tr><br/>
    <%--<c:out value="${apartment}"/><br/>--%>
</c:forEach>
</table>
</body>
</html>