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
<c:forEach var="apartment" items="${apartmentList}">
    <c:out value="${apartment}"/><br/>
</c:forEach>
</body>
</html>
