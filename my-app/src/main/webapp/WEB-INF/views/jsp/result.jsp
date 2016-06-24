
<jsp:include page="../fragments/header.jsp" />
<div class="container" style="margin-top:80px;">
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" 
                aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
        <strong>${message}</strong>
    </div>

    <h1>Student Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">Name</label>
        <div class="col-sm-10">${student.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Surname</label>
        <div class="col-sm-10">${student.surname}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Birthday</label>
        <div class="col-sm-10"><fmt:formatDate pattern="dd.MM.yyyy" value="${student.birthday}"/></div>
    </div>

    <div class="row">
        <label class="col-sm-2">Gender</label>
        <div class="col-sm-10"><p class="text-lowercase">${student.gender}</p></div>
    </div>
</div>
</body>
</html>
