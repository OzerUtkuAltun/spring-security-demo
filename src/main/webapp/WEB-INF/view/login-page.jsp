<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Form</title>

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">

    <div style="width: 35%; padding-top: 35px; padding-left: 35px;">
        <div class="form-outline mb-4">
            <label class="form-label" for="username">Username</label>
            <input type="text" id="username" class="form-control" name="username"/>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4" style="margin-top: 5px">
            <label class="form-label" for="password">Password</label>
            <input type="password" id="password" class="form-control" name="password"/>
        </div>

        <!-- Submit button -->
        <input style="margin-top: 5px;" type="submit" class="btn btn-primary btn-block mb-4" value="Login"/>


        <c:if test="${param.error != null}">
            <i style="margin-top: 5px; color: red;">Sorry! You entered invalid username or password!</i>
        </c:if>

    </div>


</form:form>

</body>
</html>
