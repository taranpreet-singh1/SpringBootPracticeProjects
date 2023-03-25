 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Your Expenses</title>
    </head>
    <body>
    <div class="container">
        <div>Welcome to expenses Page</div>


         <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Description</th>
                        <th>Amount</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${expenses}" var="expense">
                        <tr>
                            <td>${expense.id}</td>
                            <td>${expense.description}</td>
                            <td>${expense.amount}</td>
                            <td><a href="delete-expense?id=${expense.id}" class="btn btn-warning">Delete</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
                </table>
            <a href="add-expense" class="btn btn-success">Add Expense</a>
                <script src ="webjars/bootstrap/5.1.3/css/bootstrap.min.js"></script>
                <script src ="webjars/jquery/3.6.0/jquery.min.js"></script>
         </div>
    </body>
</html>