 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Add an Expense</title>
    </head>
    <body>
    <div class="container">
        <div>Enter expense details</div>
        <form:form method="post" modelAttribute="expense">
            Description: <form:input type="text" path="description"/>
            <form:errors path="description" cssClass="text-warning"/>
            <form:input type="hidden" path="id"/>
            Amount: <input type="number" name="amount" />
            <input type="submit" class="btn btn-success"/>
        </form:form>


                <script src ="webjars/bootstrap/5.1.3/css/bootstrap.min.js"></script>
                <script src ="webjars/jquery/3.6.0/jquery.min.js"></script>
         </div>
    </body>
</html>