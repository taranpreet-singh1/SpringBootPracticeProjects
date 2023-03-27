
 <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>

    <div class="container">
      <h1>Welcome to your Notepad</h1>

         <table class="table">
                <thead>
                    <tr>
                        <th>Heading</th>
                        <th>Description</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${notes}" var="note">
                        <tr>
                            <td>${note.heading}</td>
                            <td>${note.description}</td>
                            <td><a href="delete-note?id=${note.id}" class="btn btn-warning">Delete</a></td>
                             <td><a href="update-note?id=${note.id}" class="btn btn-success">Update</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
                </table>
      <a href="add-note" class="btn btn-success"> Add Note</a>
    </div>
<%@ include file="common/footer.jspf" %>