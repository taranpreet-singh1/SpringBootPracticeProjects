  <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>

    <div class="container">
        <h1> Enter your Note </h1>
        <form:form method="post" modelAttribute="note">
        <fieldset class="mb-3">
            <form:label path="noteHeading">Heading:</form:label>
            <form:input type="text" class="form-control"  path="noteHeading" required="required"/>
            <form:errors path="noteHeading" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path = "noteDescription">Note Description:</form:label>
            <form:input type="text" class="form-control" path="noteDescription" required="required"/>
            <form:errors path="noteDescription" cssClass="text-warning" />
        </fieldset>

        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <input type="submit" class="btn btn-success" />

        </form:form>
    </div>







    <%@ include file="common/footer.jspf" %>
