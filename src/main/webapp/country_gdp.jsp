<%--
  Created by IntelliJ IDEA.
  User: nathanielellsworth
  Date: 11/7/16
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<form action="/mvc/country/all/records" method="post">
    <select name='dropdown' onchange='this.form.submit()'>
            <c:forEach items="${country}" var="aCountry">
                <option value="<c:out value="${aCountry.name}"/>"><c:out value="${aCountry.name}"/></option>
            </c:forEach>
</select>
    <noscript><input type="submit" value="Submit"></noscript>
</form>


<center><h4>Country's annual GDP growth (or shrink)</h4></center>


<table border="1" class="table">
    <tr><th>area_name</th><th>measurement</th><th>value</th><th>year</th></tr>
    <tbody>
    <c:forEach items="${records}" var="aRecord">
        <tr>
            <td><c:out value="${aRecord.area_name}"/></td>
            <td><c:out value="${aRecord.measurement}"/></td>
            <td><c:out value="${aRecord.value}"/></td>
            <td><c:out value="${aRecord.year}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



</body>
</html>
