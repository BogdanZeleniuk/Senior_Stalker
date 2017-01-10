<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="stalker" tagdir="/WEB-INF/tags"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<body>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <div class="nav navbar-nav navbar-left">
            <h4>Please, set your name, email and password to continue!</h4>
            <br/>
            <div class="view-box">
                <form:form modelAttribute="userDTO" class="form-horizontal" method="post"
                           action="register" charset="utf-8"
                           accept-charset="UTF-8">

                    <stalker:inputField label="Name" name="name"/>
                    <stalker:inputField label="Email" name="email"/>
                    <stalker:inputField label="Password" name="password" inputType="password"/>

                    <div class="form-group">
                        <div class="col-sm-9">
                            <button type="submit" class="btn btn-info">Register</button>
                        </div>
                    </div>
                </form:form>
            </div>
                </div>
        </div>
    </div>
</div>
</body>
</html>