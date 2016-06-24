<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=uft-8">
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
        <script href="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
        <title>New student</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">New student</a>
                </div>
            </div>
        </nav> 

        <form:form id="form" method="post" modelAttribute="studentForm" class="form-horizontal" role="form" action="/my-app/student/result" style="margin-top:80px;">                
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:label class="col-lg-2 control-label" path="name"> 
                        Name 
                    </form:label>
                    <div class="col-lg-6">
                        <form:input path="name" class="form-control" placeholder="Name"/>
                        <form:errors path="name" class="control-label"/>
                    </div>
                </div>
            </spring:bind>    
            <spring:bind path="surname">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:label class="col-lg-2 control-label" path="surname">
                        Surname 
                    </form:label>
                    <div class="col-lg-6">
                        <form:input class="form-control" path="surname" placeholder="Surname" />
                        <form:errors path="surname" class="control-label"/>
                    </div>
                </div>
            </spring:bind>
            <spring:bind path="birthday">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:label class="col-lg-2 control-label" path="birthday">            
                        Birthday 
                    </form:label>
                    <div class="col-lg-6">												 
                        <form:input class="form-control" path="birthday" size="16" placeholder="dd.mm.yyyy"/>
                        <form:errors path="birthday" class="control-label" />
                    </div>
                </div>
            </spring:bind>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label class="col-lg-2 control-label" path="gender">            
                    Gender 
                </form:label>
                <div class="col-lg-6" style="padding-top:7px;">												 
                    <form:radiobutton path="gender" value="MALE"/> Male
                    <form:radiobutton path="gender" value="FEMALE"/> Female 
                </div>

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="Submit">
                </div>
            </div>			
            </form:form>

    </body>
</html>