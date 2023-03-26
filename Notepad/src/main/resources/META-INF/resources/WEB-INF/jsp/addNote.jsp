  <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>

    <div class="container">
        <h1> Enter your Note </h1>
        <form:form method="post" modelAttribute="note">
        <fieldset class="mb-3">
            <form:label path="heading">Heading:</form:label>
            <form:input type="text" class="form-control"  path="heading" required="required"/>
            <form:errors path="heading" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path = "description">Note Description:</form:label>
            <form:input type="text" class="form-control" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning" />
        </fieldset>

        <form:input type="hidden" path="id" />
        <input type="submit" class="btn btn-success" />

        </form:form>
    </div>







    <%@ include file="common/footer.jspf" %>
