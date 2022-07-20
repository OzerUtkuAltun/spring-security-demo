<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Company Home Page</title>
</head>
<body>

    <h2>Company Home Page</h2>
    <hr>
    Welcome to company home page!
    <hr>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">

        <input type="submit" value="Logout"/>
    </form:form>
</body>
</html>
