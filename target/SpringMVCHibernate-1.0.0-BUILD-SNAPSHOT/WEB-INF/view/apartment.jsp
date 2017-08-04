<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Apartment</title>
</head>
<body>
<c:out value="apartment" />
<form method="post" action="controller/apartment/${apartment.id}/delete">
    <button value="Delete" onclick="confirm('Вы уверены?')"/>
</form>
</body>
</html>
