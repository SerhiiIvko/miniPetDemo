<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.1.3/css/bootstrap.min.css">
    <title>Main page</title>
    <style type="text/css">
        body {
            background-image: url("img/orig.jpeg");
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="container" align="center">
    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <h3>Main page</h3>
        </div>
    </div>
    <div class="col-xs-3">
        <a href="${pageContext.request.contextPath}/managers?_method=head" type="button"
           class="btn btn-primary btn-success">Status</a>
        <br/><br/>
    </div>
    <div class="col-xs-3">
        <a href="${pageContext.request.contextPath}/managers" type="button" class="btn btn-primary btn-success">Show all
            managers</a>
    </div>
    <br/><br/>
</div>
<script type="text/javascript" src="libs/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="libs/propper-1.11.0/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.1.3/js/bootstrap.min.js"></script>
</body>
</html>