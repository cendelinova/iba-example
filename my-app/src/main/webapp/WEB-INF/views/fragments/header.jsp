<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=uft-8">
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>   
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
        <spring:url value="/resources/js/validation.js" var="validation"/>
        <spring:url value="/resources/js/bootstrap.min.js" var="bootstrap.js"/>
        <script src="${bootstrap.js}"></script>
        <script src="${validation}"></script>
        
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <a class="navbar-brand" href="#">IBA project</a>
            <ul class="nav navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/my-app/student">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/my-app/student/add">Add student</a>
                </li>
            </ul>
        </nav> 

