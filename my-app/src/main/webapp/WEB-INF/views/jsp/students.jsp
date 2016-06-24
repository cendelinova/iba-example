<jsp:include page="../fragments/header.jsp" />
<div class="container" style="margin-top: 80px;">
    <h1>All students</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Birthday</th>
                <th>Gender</th>
            </tr>
        </thead>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>$<fmt:formatDate pattern="dd.MM.yyyy" value="${student.birthday}"/></td>
                <td>${student.gender}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
