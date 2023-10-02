<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="c1" uri="jakarta.tags.fmt" %>


<!doctype html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ChatsTeamProject</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ui/css/bootstrap.css">
</head>

<body>
<div class="container">
    <div class="login">
        <form action="${pageContext.request.contextPath}/api/login" method="post">
            <div class="row">
                <h2>Sign Up</h2>
                <div class="col-md-12">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" placeholder="youremail@mail.com">
                    <br>
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="password">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <input type="submit" id="register" value="Signup" class="btn btn-outline-success btn-form">
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</div>


</body>
</html>