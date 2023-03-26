
    <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>

    <div class="container">
        <div>Enter expense details</div>
        <form:form method="post" modelAttribute="expense">
            Description: <form:input type="text" path="description"/>
            <form:errors path="description" cssClass="text-warning"/>
            <form:input type="hidden" path="id"/>
            Amount: <input type="number" name="amount" />
            <input type="submit" class="btn btn-success"/>
        </form:form>


              <%@ include file="common/footer.jspf" %>