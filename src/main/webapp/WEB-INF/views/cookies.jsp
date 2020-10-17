<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies</title>
</head>
<body>
<c:forEach items="${cookiesList}" var="c">
    Name: ${c.name} Value: ${c.value}<br/>
</c:forEach>

</body>
</html>
