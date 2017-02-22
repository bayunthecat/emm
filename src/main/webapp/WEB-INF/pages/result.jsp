<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/components/jsp/head.jsp">
    <jsp:param name="title" value="Result" />
</jsp:include>
<body>
   <p><s:property value="result" default="insert failed"/></p>
</body>
</html>