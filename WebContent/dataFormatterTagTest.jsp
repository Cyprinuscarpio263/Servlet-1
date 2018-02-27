<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="easy" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing DataFormatterTag</title>
</head>
<body>
<easy:dataFormatter items="Zhejiang,Shaanxi,Guangdong" header="Provinces"/>
<br/>
<easy:dataFormatter items="China,Korea,Combodia,Vietnam" header="Countries"/>
</body>
</html>