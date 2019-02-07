<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <style type="text/css">
        body {
            background-image: url("img/orig.jpeg");
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-start">
        <div class="col-md-auto">
            <h3>${title}</h3>
        </div>
    </div>
    <div class="col-xs-3">
        <ul>
            <c:forEach var="pair" items="${pairs}">
                <li><strong>${pair.left}:</strong> ${pair.right}</li>
            </c:forEach>
        </ul>
    </div>
    <br/><br/>
    <div class="col-xs-3">
        <a href="index.jsp" type="button" class="btn btn-primary">Main Page</a>
    </div>
</div>
</body>
</html>