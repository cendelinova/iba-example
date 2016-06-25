<%@include file="../fragments/header.jsp" %>
<form:form id="form" method="post" modelAttribute="studentForm" class="form-horizontal" role="form" action="/my-app/student/add" style="margin-top:80px;">
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
            <input Type="button" class="btn btn-danger" value="Back" onClick="history.go(-1);return true;">
        </div>
    </div>			
</form:form>
</body>
</html>