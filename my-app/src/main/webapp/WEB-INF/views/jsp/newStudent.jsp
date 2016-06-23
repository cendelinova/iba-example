<%-- 
    Document   : newStudent
    Created on : 22.6.2016, 22:28:30
    Author     : Petra
--%>

<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>New student</title>
    </head>
    <body>
    <form:form>
        <table>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"/></td>
                <%-- Show errors for firstName field --%>
            <td><form:errors path="firstName"/></td>
            </tr>

            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName"/></td>
                <%-- Show errors for lastName field --%>
            <td><form:errors path="lastName"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Save Changes"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
