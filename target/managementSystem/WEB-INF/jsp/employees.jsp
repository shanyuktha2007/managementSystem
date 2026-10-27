
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f1f5fb;
            margin: 30px;
        }

        .container {
            max-width: 950px;
            margin: auto;
            padding: 25px;
            background: white;
            border-radius: 10px;
        }

        input {
            box-sizing: border-box;
            width: 100%;
            padding: 10px;
            margin: 8px 0;
        }

        button {
            background: #1559a8;
            color: white;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background: #1559a8;
            color: white;
        }

        .error {
            color: #c62828;
            display: block;
            margin-bottom: 8px;
        }

        .success {
            color: green;
        }
    </style>
</head>

<body>
<div class="container">

    <h1>Employee Management System</h1>

    <c:if test="${not empty successMessage}">
        <p class="success">
            <c:out value="${successMessage}"/>
        </p>
    </c:if>

    <h2>Register Employee</h2>

    <form:form modelAttribute="employee"
               action="${pageContext.request.contextPath}/employees"
               method="post">

        <label>Employee Name</label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>

        <label>Email</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>

        <label>Department</label>
        <form:input path="department"/>
        <form:errors path="department" cssClass="error"/>

        <label>Salary</label>
        <form:input path="salary" type="number"
                    step="0.01" min="0.01"/>
        <form:errors path="salary" cssClass="error"/>

        <button type="submit">Register Employee</button>

    </form:form>

    <h2>Employee List</h2>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>
        </thead>

        <tbody>
        <c:choose>
            <c:when test="${empty employees}">
                <tr>
                    <td colspan="5">No employees registered yet.</td>
                </tr>
            </c:when>

            <c:otherwise>
                <c:forEach var="emp" items="${employees}">
                    <tr>
                        <td><c:out value="${emp.id}"/></td>
                        <td><c:out value="${emp.name}"/></td>
                        <td><c:out value="${emp.email}"/></td>
                        <td><c:out value="${emp.department}"/></td>
                        <td><c:out value="${emp.salary}"/></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>

</div>
</body>
</html>
