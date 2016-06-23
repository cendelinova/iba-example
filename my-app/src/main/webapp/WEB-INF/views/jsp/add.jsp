<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="name"> 
                    Name <form:errors path="name" />
                </form:label>
                <div class="col-lg-6">
                    <form:input path="name" class="form-control" placeholder="Name"/>
                </div>
            </div>	
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="surname">
                    Surname <form:errors path="surname" />
                </form:label>
                <div class="col-lg-6">
                    <form:input class="form-control" path="surname" placeholder="Surname" />
                </div>
            </div>
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="birthday">            
                    Birthday <form:errors path="birthday"/>
                </form:label>
                <div class="col-lg-6">												 
                    <form:input class="form-control" path="birthday" size="16" placeholder="dd.mm.yyyy"/>	                    
                </div>
            </div>
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="gender">            
                    Gender <form:errors path="gender"/>
                </form:label>
                <div class="col-lg-6" style="padding-top:7px;">												 
                    <form:radiobutton path="gender" value="MALE"/> Male
                    <form:radiobutton path="gender" value="FEMALE"/> Female 	                    
                </div>
            </div>
            <div class="form-group"><input type="submit" value="Submit" class="btn btn-primary"></div>			
            </form:form>

    </body>
</html>