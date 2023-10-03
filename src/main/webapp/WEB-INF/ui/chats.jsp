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
    <style>
        .nav_menu li {
            float: left;
            display: inline;
        }

        .nav_menu a {
            cursor: pointer;
            background-color: #282A35;
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .nav_menu ul {
            background-color: #282A35;
            overflow: hidden;
        }

        .nav_menu .active {
            background-color: #04AA6D;
        }

        .nav_menu {

        }

        .nav_menu li a:hover {
            background-color: #111;
        }

        .container {
            text-align: left;
            padding: 14px 16px;
            border-radius: 0;
            background-color: #E7E9EB;
        }

        .container .btn-outline-success {
            color: #28a745;
            border-color: #28a745;
        }

        .container .btn {
            background-color: transparent;
            border: 1px solid transparent;
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            line-height: 1.5;
            border-radius: 0.25rem;
        }

        .container .row {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            margin-right: -15px;
            margin-left: -15px;
        }

        .container .h2 {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            margin-right: -15px;
            margin-left: -15px;
        }

        .col-md-12 {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
            display: -ms-flexbox;
            display: flex;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            margin-right: 15px;
            margin-left: 15px;
        }

        .col-md-12 td, .col-md-12 th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        .col-md-12 tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .col-md-12 tr:hover {
            background-color: #ddd;
        }

        .col-md-12 th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }

        #chats {
            width: 100%;
        }


        html, body {
            font-family: Verdana, sans-serif;
            font-size: 15px;
            line-height: 1.5;
        }
    </style>
</head>
<body>
<div class="nav_menu">
    <ul class="horizontal">
        <li><a href="#home">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/api/chats">Chats</a></li>
        <li><a href="${pageContext.request.contextPath}/user/message">Message</a></li>
        <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>
</div>

<div class="container">
    <div class="login">
        <div class="row">
            <h2>Chats</h2>
            <div class="col-md-12">
                <table id="chats">
                    <c:forEach var="entry" items="${chat}">
                        <tr>
                            <th>${entry.value.getDate}</th>
                            <th>${entry.value.getMessageBody}</th>
                            <th>${entry.key}</th>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </div>
</div>


</body>