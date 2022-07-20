<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>

    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">

        <p>
            Username: <input type="text" name="username"/>
        </p>
        <p>
            Password: <input type="password" name="password"/>
        </p>

        <input type="submit" value="login"/>

    </form:form>

</body>
</html>
