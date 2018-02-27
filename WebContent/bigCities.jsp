<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Big Cities</title>
<style>
table, tr, td {
	border: 1px solid #aaee77;
	padding: 3px;
}
</style>
</head>
<body>
Capitals:
<table>
	<tr style="background:#448755;color:white;font-weight:bold;">
		<td>Country</td>
		<td>Capital</td>
	</tr>
	<c:forEach items="${requestScope.capitals }" var="mapItem">
		<tr>
			<td>${mapItem.key }</td>
			<td>${mapItem.value }</td>
		</tr>
	</c:forEach>
</table>
<br/>
Big Cities:
<table>
	<tr style="background:#448755;color:white;font-weight:bold;">
		<td>Country</td>
		<td>Cities</td>
	</tr>
	<c:forEach items="${requestScope.bigCities }" var="mapItem">
		<tr>
			<td>${mapItem.key }</td>
			<td>
				<c:forEach items="${mapItem.value }" var="city" varStatus="vs">
					${city }<c:if test="${!vs.last }">,</c:if>
				</c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
<br/>
<hr/>
<c:set var="map" value="${requestScope.capitals }"/>
1=${map.china }, 2=${map.China }, 3=${map['China'] }, 4=${map['china'] }
</body>
</html>