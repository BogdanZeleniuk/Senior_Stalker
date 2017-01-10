<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">

<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
            <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <c:url value="/j_spring_security_check" var="loginUrl"/>
                    <form:form class="navbar-form" role="form" action="${loginUrl}"
                         method="post">
                        <div class="form-group">
                            <label for="username">Email:</label>
                            <div class="col-sm-3">
                                <input type="text" placeholder="Login" class="form-control" name="username" id="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <div class="col-sm-3">
                                <input type="password" placeholder="Password" class="form-control" name="password" id="password">
                            </div>
                        </div>
                        <div class="form-group">
                        <button type="submit" class="btn btn-success">Sign in</button>
                        </div>
                    </form:form>
                    <br/>
                    <form class="navbar-form">
                            <a class="btn btn-sm btn-block btn-primary" role="button" href="register">Register</a>
                    </form>
                </li>
                </ul>
            </div>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <br/><br/>
        <c:if test="${error eq true}">
            <div class="error">
                <br/><br/>
                    <spring:message code="duplicate.login"/>
            </div>
        </c:if>
        <c:if test="${error eq false}">
            <div class="error">
            </div>
        </c:if>
        <c:if test="${not empty message}">
            <br/><br/>
            <div class="message">
                <spring:message code="${message}"/>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>