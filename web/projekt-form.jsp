<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodawanie projektu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <h1>Dodawanie/Edycja projektu</h1>
    <hr/>

    <div class="row">
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/ProjektServlet" method="POST">

                <c:if test="${projekt.projektId ne null}">
                    ID:
                    <div class="form-group">
                        <input type="text" class="form-control" name="id" value="${projekt.projektId}" disabled></td>
                    </div>
                </c:if>

                <div class="form-group">
                    Nazwa:
                    <input type="text" class="form-control" name="nazwa" placeholder="Wpisz nazwe"
                           value="${projekt.nazwa}" required/>
                </div>

                <div class="form-group">
                    Opis:
                    <input type="text" class="form-control" name="opis" placeholder="Wpisz opis" value="${projekt.opis}"
                           required/>
                </div>

                <div class="form-group">
                    Data oddania:
                    <input type="date" class="form-control" name="data_oddania" value="${projekt.data_oddania}"
                           required/>
                </div>

                <input type="hidden" name="id" value="${projekt.projektId}"/>

                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/ProjektServlet?action=LIST">Powrót do listy</a>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>