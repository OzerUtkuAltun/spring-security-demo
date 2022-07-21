<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Company Home Page</title>
</head>
<body>

<h2>Company Home Page</h2>
<hr>
Welcome to company home page! <br>

<%--    displaying user ID--%>
User: <security:authentication property="principal.username"/> <br>
Role(s): <security:authentication property="principal.authorities" />
<hr>

<p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting (Only for Managers)</a>
</p>

<p>
    <a href="${pageContext.request.contextPath}/systems">IT System Meeting (Only for Admins)</a>
</p>


<hr>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">

    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
