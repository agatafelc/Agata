<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Projekty</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>

<div class = "container">

    <h1>Projekty</h1>

    <p>${NOTIFICATION}</p>

    <p>
        <button class = "btn btn-primary" onclick="window.location.href = 'projekt-form.jsp'">Dodaj projekt</button>
    </p>

    <table class = "table table-striped table-bordered" id="datatable">

        <tr class = "thead-dark">
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Data oddania</th>
            <th>Ostatnia aktualizacja</th>
        </tr>

        <c:forEach items="${projektList}" var="projekt">

            <tr>
                <td>${projekt.nazwa}</td>
                <td>${projekt.opis}</td>
                <td>${projekt.data_oddania}</td>
                <td><javatime:format value="${projekt.dataCzasModyfikacji}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                <td>
                    <a href = "${pageContext.request.contextPath}/ProjektServlet?action=TASKS&id=${projekt.projektId}">Zadania</a>
                    |
                    <a href = "${pageContext.request.contextPath}/ProjektServlet?action=EDIT&id=${projekt.projektId}">Edytuj</a>
                    |
                    <a href = "${pageContext.request.contextPath}/ProjektServlet?action=DELETE&id=${projekt.projektId}">Usuń</a>
                </td>
            </tr>

        </c:forEach>

    </table>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
