<%@include file="../fragments/header.jsp" %>
<div class="container" style="margin-top: 80px;">
    <h1>All students</h1>
    <c:choose>
        <c:when test="${empty students}">
            <h3>You haven't added any students yet. Would you like to create some? </h3> <a class="btn btn-primary" href="/my-app/student/add" role="button">Add student</a>
        </c:when>
        <c:otherwise>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.name}</td>
                        <td>${student.surname}</td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${student.birthday}"/></td>
                        <td><p class="text-lowercase">${student.gender}</p></td>
                        <td>
                            <spring:url value="/student/${student.id}/detail" var="studentUrl" />
                            <spring:url value="/student/${student.id}/delete" var="deleteUrl" /> 
                            <spring:url value="/student/${student.id}/update" var="updateUrl" />

                            <button class="btn btn-info" 
                                    onclick="location.href = '${studentUrl}'">Detail</button>
                            <button class="btn btn-primary" 
                                    onclick="location.href = '${updateUrl}'">Update</button>
                            <button class="btn btn-danger" 
                                    onclick="location.href = '${deleteUrl}'">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
