
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/8/2025
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>User List</title>
  <style>
    body{font-family:Arial, sans-serif;background:#f7f7f7;padding:24px}
    .wrap{max-width:900px;margin:auto;background:#fff;border-radius:10px;box-shadow:0 4px 16px rgba(0,0,0,.08);padding:20px}
    h2{margin:0 0 16px}
    table{width:100%;border-collapse:collapse}
    th,td{padding:10px;border-bottom:1px solid #eee;text-align:left}
    th{background:#fafafa}
    tr:hover{background:#fcfcff}
  </style>
</head>
<body>
<div class="wrap">
  <h2>User List</h2>

  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>Birthday</th>
      <th>Gender</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${userList}" varStatus="s">
      <tr>
        <td>${u.id}</td>
        <td>${u.firstName}</td>
        <td>${u.lastName}</td>
        <td>${u.email}</td>
        <td>${u.birthday}</td>
        <td>${u.gender}</td>
      </tr>
    </c:forEach>
    <c:if test="${empty userList}">
      <tr><td colspan="6">No users yet.</td></tr>
    </c:if>
    </tbody>
  </table>

  <p style="margin-top:16px;"><a href="register-form.jsp">Add new user</a></p>
</div>
</body>
</html>
