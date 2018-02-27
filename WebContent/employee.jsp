<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<body>
accept-language: ${header['accept-language'] }
<br/>
session id: ${pageContext.session.id }
<br/>
employee: ${requestScope.employee.name}, ${employee.address.city}
<br/>
capitals: ${capitals["China"]}
<br/><br/>
c:out: <c:out value="${employee.name }">Default value</c:out>
<br/>
EL: ${employee['name'] }
<hr/>
<c:forEach var="x" varStatus="i" begin="0" end="10" step="1">
	Number[${i.count}]: ${x }<br/>
</c:forEach>
</body>
</html>