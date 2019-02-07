<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Managers</title>
    <meta charset="utf-8">
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
<div>
    <div class="body">
        <div class="container" align="center">
            <div class="row">
                <div class="col-xs-6 whiteback">
                    <h3 class="text-center">List of Managers</h3>
                    <hr>
                    <div class="row" align="center">
                        <form method="get" action="${pageContext.request.contextPath}/managers?id=${id}">
                            <div class="col-xs-3" align="center">
                                <label>
                                    <input type="search" name="id">
                                </label>
                            </div>
                            <div class="col-xs-3">
                                <input type="submit" value="Search" class="btn btn-primary btn-success"
                                       placeholder="Search by id">
                            </div>
                        </form>
                    </div>
                    <hr>
                    <div class="row justify-content-md-center">
                        <div class="col-xs-10 table-responsive justify-content-md-center">
                            <form class="col-10 justify-content-md-center"
                                  action="${pageContext.request.contextPath}/managers" method="get">
                                <table class="table" id="table">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>name</th>
                                        <th>surname</th>
                                        <th>age</th>
                                        <th>email</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <input type="hidden" name="saveList" value="true">
                                    <input type="hidden" name="_method" value="put">
                                    <c:forEach var="manager" items="${managers}">
                                        <tr>
                                            <td>
                                                <div class="form-group" class="col-xs-1">
                                                    <input name="id_${manager.id}" type="text" class="form-control"
                                                           id="managerId"
                                                           placeholder="id" value="${manager.id}" readonly>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="name_${manager.id}" type="text" class="form-control"
                                                           id="managerName"
                                                           placeholder="name" value="${manager.name}">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="surname_${manager.id}" type="text" class="form-control"
                                                           id="managerSurname" placeholder="surname"
                                                           value="${manager.surname}">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-1">
                                                    <input name="age_${manager.id}" type="number" class="form-control"
                                                           id="managerAge"
                                                           placeholder="age" value="${manager.age}">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group" class="col-xs-2">
                                                    <input name="email_${manager.id}" type="email" class="form-control"
                                                           id="managerEmail"
                                                           aria-describedby="emailHelp" placeholder="email"
                                                           value="${manager.email}">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col-xs-1">
                                                    <a href="${pageContext.request.contextPath}/managers?id=${manager.id}"
                                                       type="button"
                                                       class="btn btn-primary btn-success">Show</a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col-xs-1">
                                                    <a href="${pageContext.request.contextPath}/managers?id=${manager.id}&_method=delete"
                                                       type="button"
                                                       class="btn btn-primary">Delete</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="col-xs-3">
                                    <input type="submit" class="btn btn-primary btn-success" value="Save changes"/>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <a href="${pageContext.request.contextPath}/profile.jsp?create=true" type="button"
                           class="btn btn-primary">Add Manager</a>
                    </div>
                    <br/><br/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>